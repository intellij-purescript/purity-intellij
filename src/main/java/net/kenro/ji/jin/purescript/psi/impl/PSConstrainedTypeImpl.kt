package net.kenro.ji.jin.purescript.psi.impl

import com.intellij.lang.ASTNode
import net.kenro.ji.jin.purescript.psi.PSConstrainedType

class PSConstrainedTypeImpl(node: ASTNode) : PSPsiElement(node),
    PSConstrainedType