package org.purescript.parser

import org.purescript.parser.Combinators.token
import org.purescript.parser.PSTokens.Companion.ARROW
import org.purescript.parser.PSTokens.Companion.AS
import org.purescript.parser.PSTokens.Companion.BACKSLASH
import org.purescript.parser.PSTokens.Companion.CASE
import org.purescript.parser.PSTokens.Companion.CHAR
import org.purescript.parser.PSTokens.Companion.DARROW
import org.purescript.parser.PSTokens.Companion.DCOLON
import org.purescript.parser.PSTokens.Companion.DDOT
import org.purescript.parser.PSTokens.Companion.DOT
import org.purescript.parser.PSTokens.Companion.EQ
import org.purescript.parser.PSTokens.Companion.FORALL
import org.purescript.parser.PSTokens.Companion.LARROW
import org.purescript.parser.PSTokens.Companion.OF
import org.purescript.parser.PSTokens.Companion.STRING
import org.purescript.parser.PSTokens.Companion.TICK
import org.purescript.parser.PSTokens.Companion.WHERE

val `as` = token(AS)
val arrow = token(ARROW)
val backslash = token(BACKSLASH)
val case = token(CASE)
val char = token(CHAR)
val darrow = token(DARROW)
val dcolon = token(DCOLON)
val ddot = token(DDOT)
val dot = token(DOT)
val eq = token(EQ)
val forall = token(FORALL)
val larrow = token(LARROW)
val of = token(OF)
val string = token(STRING)
val tick = token(TICK)
val where = token(WHERE)

@Suppress("ObjectPropertyName")
val `@` = token("@")
@Suppress("ObjectPropertyName")
val `_` = token("_")
