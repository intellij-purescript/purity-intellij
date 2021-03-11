package org.purescript.psi.`var`

import com.intellij.psi.PsiNamedElement
import com.intellij.psi.util.PsiTreeUtil
import org.purescript.file.PSFile
import org.purescript.parser.PSLanguageParserTestBase
import org.purescript.psi.data.PSDataDeclaration
import org.purescript.psi.PSIdentifier
import org.purescript.psi.PSValueDeclaration
import org.purescript.psi.PSVarBinderImpl

class ReferenceTest : PSLanguageParserTestBase("parser") {
    fun testFindTopLevelValueDeclarationWithName() {
        val file = createFile(
            "Main.purs",
            """
                  module Main where
                  x = 1
                  y = 2
                  """.trimIndent()
        ) as PSFile
        val valueDeclarations = file.topLevelValueDeclarations
        assertSize(2, valueDeclarations.keys)
        assertNotNull(valueDeclarations["x"])
        assertNotNull(valueDeclarations["y"])
    }

    fun testFindVarBinderParametersForValueDeclaration() {
        val file = createFile(
            "Main.purs",
            """
                  module Main where
                  fn x (z) (Just n) = x + y
                  y = 2
                  """.trimIndent()
        ) as PSFile
        val valueDeclarations = file.topLevelValueDeclarations
        val fn:PSValueDeclaration = valueDeclarations["fn"]!!.first()
        val varBinders:Map<String, PSVarBinderImpl> = fn.varBindersInParameters
        assertContainsElements(varBinders.keys, "x", "z", "n")
        assertDoesntContain(varBinders.keys, "fn", "y", "Just")
        val x = varBinders["x"]
        assertEquals("x", x!!.name)
    }

    @Suppress("unused")
    fun ignoreTestIdentifierCanResolveToTypeConstructor() {
        val file = createFile(
                "Main.purs",
                """
                module Data where
                data A = A
                func :: A -> A
                func a = a
                """.trimIndent()
        ) as PSFile
        val elementAtCursor = file.findElementAt(38)
        val psIdentifier = if (elementAtCursor is PSIdentifier)
            elementAtCursor
        else
            PsiTreeUtil.findFirstParent(elementAtCursor)
            { it is PSIdentifier } as PSIdentifier
        val reference = psIdentifier.reference
        val resolved = reference!!.resolve()
        assertInstanceOf(resolved, PSDataDeclaration::class.java)
        assertEquals("A", (resolved as PsiNamedElement).name)
    }

}
