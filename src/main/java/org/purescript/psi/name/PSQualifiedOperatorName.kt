package org.purescript.psi.name

import com.intellij.lang.ASTNode
import org.purescript.psi.PSPsiElement

/**
 * A operator that may be qualified
 * `P.x` in
 * ```
 * x = 1 P.+ 1
 * ```
 */
class PSQualifiedOperatorName(node: ASTNode) : PSPsiElement(node) {

    val moduleName: PSModuleName?
        get() = findChildByClass(PSModuleName::class.java)

    val operatorName: PSOperatorName
        get() = findNotNullChildByClass(PSOperatorName::class.java)
}
