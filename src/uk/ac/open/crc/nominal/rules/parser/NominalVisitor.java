// Generated from /home/simon/PhD/src/nominal/src/uk/ac/open/crc/nominal/rules/parser/Nominal.g4 by ANTLR 4.1

    package uk.ac.open.crc.nominal.rules.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NominalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NominalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NominalParser#firstCharDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstCharDefinition(@NotNull NominalParser.FirstCharDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#lengthTokenDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthTokenDefinition(@NotNull NominalParser.LengthTokenDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#methodContentDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodContentDefinition(@NotNull NominalParser.MethodContentDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#labelRuleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelRuleDefinition(@NotNull NominalParser.LabelRuleDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#referenceContentDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceContentDefinition(@NotNull NominalParser.ReferenceContentDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#cipherDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCipherDeclaration(@NotNull NominalParser.CipherDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#bodyValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyValue(@NotNull NominalParser.BodyValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#pluralDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPluralDefinition(@NotNull NominalParser.PluralDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#listDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListDefinition(@NotNull NominalParser.ListDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#referenceRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceRule(@NotNull NominalParser.ReferenceRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#cipherDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCipherDefinition(@NotNull NominalParser.CipherDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#labelContentDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelContentDefinition(@NotNull NominalParser.LabelContentDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#globalRulesDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalRulesDefinition(@NotNull NominalParser.GlobalRulesDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#cipherListDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCipherListDefinition(@NotNull NominalParser.CipherListDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(@NotNull NominalParser.FileContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#labelRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelRule(@NotNull NominalParser.LabelRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#methodRuleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodRuleDefinition(@NotNull NominalParser.MethodRuleDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#typeAcronym}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAcronym(@NotNull NominalParser.TypeAcronymContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#acronymTypography}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcronymTypography(@NotNull NominalParser.AcronymTypographyContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#acronymTypographyRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcronymTypographyRule(@NotNull NominalParser.AcronymTypographyRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#methodRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodRule(@NotNull NominalParser.MethodRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#typographyDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypographyDefinition(@NotNull NominalParser.TypographyDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#bodyDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyDefinition(@NotNull NominalParser.BodyDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#separatorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeparatorDefinition(@NotNull NominalParser.SeparatorDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#methodContentSetting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodContentSetting(@NotNull NominalParser.MethodContentSettingContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#referenceContentSetting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceContentSetting(@NotNull NominalParser.ReferenceContentSettingContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#javaTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJavaTypeName(@NotNull NominalParser.JavaTypeNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#subspeciesRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubspeciesRule(@NotNull NominalParser.SubspeciesRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#prefixDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixDefinition(@NotNull NominalParser.PrefixDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#firstCharValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstCharValue(@NotNull NominalParser.FirstCharValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#referenceRuleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceRuleDefinition(@NotNull NominalParser.ReferenceRuleDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#phraseValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhraseValue(@NotNull NominalParser.PhraseValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#typeContentSetting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeContentSetting(@NotNull NominalParser.TypeContentSettingContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#prefixValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixValue(@NotNull NominalParser.PrefixValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#standaloneAbbreviation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandaloneAbbreviation(@NotNull NominalParser.StandaloneAbbreviationContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#separatorValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeparatorValue(@NotNull NominalParser.SeparatorValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#brandingDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrandingDefinition(@NotNull NominalParser.BrandingDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#lengthCharacterDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthCharacterDefinition(@NotNull NominalParser.LengthCharacterDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#prefixDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixDeclaration(@NotNull NominalParser.PrefixDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#typeRuleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRuleDefinition(@NotNull NominalParser.TypeRuleDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#labelContentSetting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelContentSetting(@NotNull NominalParser.LabelContentSettingContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#typeWildcardName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeWildcardName(@NotNull NominalParser.TypeWildcardNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#prefixListDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixListDefinition(@NotNull NominalParser.PrefixListDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#globalRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalRules(@NotNull NominalParser.GlobalRulesContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#typeContentDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeContentDefinition(@NotNull NominalParser.TypeContentDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(@NotNull NominalParser.ClassOrInterfaceTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#typeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRule(@NotNull NominalParser.TypeRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link NominalParser#brandingListDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrandingListDefinition(@NotNull NominalParser.BrandingListDefinitionContext ctx);
}