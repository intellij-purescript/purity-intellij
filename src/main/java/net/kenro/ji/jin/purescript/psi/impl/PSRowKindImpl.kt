package net.kenro.ji.jin.purescript.psi.impl

import com.intellij.lang.ASTNode
import net.kenro.ji.jin.purescript.psi.PSRowKind

class PSRowKindImpl(node: ASTNode) : PSPsiElement(node), PSRowKind