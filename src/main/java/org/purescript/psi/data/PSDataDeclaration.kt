package org.purescript.psi.data

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import org.purescript.psi.PSProperName
import org.purescript.psi.PSPsiElement

/**
 * A data declaration, e.g.
 *
 * ```
 * data CatQueue a = CatQueue (List a) (List a)
 * ```
 */
class PSDataDeclaration(node: ASTNode) :
    PSPsiElement(node),
    PsiNameIdentifierOwner {

    /**
     * @return the [PSProperName] that identifies this declaration
     */
    internal val identifier: PSProperName
        get() = findNotNullChildByClass(PSProperName::class.java)

    /**
     * @return the [PSDataConstructorList] in this declaration,
     * or null if it's an empty declaration
     */
    internal val dataConstructorList: PSDataConstructorList?
        get() = findChildByClass(PSDataConstructorList::class.java)

    override fun setName(name: String): PsiElement? {
        return null
    }

    override fun getNameIdentifier(): PSProperName = identifier

    override fun getName(): String = nameIdentifier.name

    override fun getTextOffset(): Int = nameIdentifier.textOffset
}
