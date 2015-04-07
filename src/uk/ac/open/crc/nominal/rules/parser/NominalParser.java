// Generated from /home/simon/PhD/src/nominal/src/uk/ac/open/crc/nominal/rules/parser/Nominal.g4 by ANTLR 4.1

    package uk.ac.open.crc.nominal.rules.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NominalParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE_SELECTOR=1, METHOD_SELECTOR=2, REFERENCE_SELECTOR=3, LABEL_SELECTOR=4, 
		GENERIC_RULE_NAME=5, ABBREVIATION=6, ACRONYMS=7, BRANDING_LIST=8, BODY=9, 
		BRAND=10, CIPHER=11, CONTENT=12, DEFAULT=13, GLOBAL=14, PLURAL=15, FIRST_CHAR=16, 
		LENGTH_CHARACTERS=17, LENGTH_TOKEN=18, PHRASE=19, PREFIX=20, PREFIX_LIST=21, 
		SEPARATOR=22, STANDALONE_ABBREVIATION=23, TYPE_ACRONYM=24, COMPOUND_PHRASE_NAME=25, 
		PHRASE_NAME=26, SEPARATOR_CHARACTER=27, JAVA_SEPARATOR_CHARACTER=28, PRIMITIVE_TYPE=29, 
		CIPHER_LIST=30, BooleanValue=31, GRAMMATICAL_NUMBER_VALUE=32, MIXED=33, 
		LOWER=34, UPPER=35, NONE=36, COMPLEX=37, COLON=38, SEMI_COLON=39, COMMA=40, 
		UNDER_SCORE=41, DOLLAR_SIGN=42, HYPHEN=43, FULL_STOP=44, BLOCK_OPEN=45, 
		BLOCK_CLOSE=46, MULTIPLIER=47, WILDCARD=48, CipherName=49, ListIdentifier=50, 
		JavaIdentifier=51, PREFIX_VALUE=52, Number=53, WS=54, LINE_COMMENT=55;
	public static final String[] tokenNames = {
		"<INVALID>", "TYPE_SELECTOR", "METHOD_SELECTOR", "REFERENCE_SELECTOR", 
		"'label'", "GENERIC_RULE_NAME", "'standalone-abbreviation'", "'acronyms'", 
		"'branding-list'", "'body'", "'brand'", "'cipher'", "'content'", "'default'", 
		"'global'", "'plural'", "'first-char'", "'length-char'", "'length-token'", 
		"'phrase'", "'prefix'", "'prefix-list'", "'separator'", "'abbreviation'", 
		"'type-acronym'", "COMPOUND_PHRASE_NAME", "PHRASE_NAME", "SEPARATOR_CHARACTER", 
		"JAVA_SEPARATOR_CHARACTER", "PRIMITIVE_TYPE", "'cipher-list'", "BooleanValue", 
		"GRAMMATICAL_NUMBER_VALUE", "'mixed'", "'lower'", "'upper'", "'none'", 
		"'complex'", "':'", "';'", "','", "'_'", "'$'", "'-'", "'.'", "'{'", "'}'", 
		"'+'", "'*'", "CipherName", "ListIdentifier", "JavaIdentifier", "PREFIX_VALUE", 
		"Number", "WS", "LINE_COMMENT"
	};
	public static final int
		RULE_file = 0, RULE_subspeciesRule = 1, RULE_typeRule = 2, RULE_methodRule = 3, 
		RULE_referenceRule = 4, RULE_labelRule = 5, RULE_typeRuleDefinition = 6, 
		RULE_methodRuleDefinition = 7, RULE_referenceRuleDefinition = 8, RULE_labelRuleDefinition = 9, 
		RULE_typographyDefinition = 10, RULE_bodyDefinition = 11, RULE_firstCharDefinition = 12, 
		RULE_prefixDefinition = 13, RULE_separatorDefinition = 14, RULE_pluralDefinition = 15, 
		RULE_cipherDefinition = 16, RULE_lengthTokenDefinition = 17, RULE_lengthCharacterDefinition = 18, 
		RULE_typeContentDefinition = 19, RULE_methodContentDefinition = 20, RULE_referenceContentDefinition = 21, 
		RULE_labelContentDefinition = 22, RULE_typeContentSetting = 23, RULE_methodContentSetting = 24, 
		RULE_referenceContentSetting = 25, RULE_labelContentSetting = 26, RULE_bodyValue = 27, 
		RULE_firstCharValue = 28, RULE_standaloneAbbreviation = 29, RULE_typeAcronym = 30, 
		RULE_phraseValue = 31, RULE_prefixValue = 32, RULE_separatorValue = 33, 
		RULE_listDefinition = 34, RULE_cipherListDefinition = 35, RULE_cipherDeclaration = 36, 
		RULE_javaTypeName = 37, RULE_typeWildcardName = 38, RULE_classOrInterfaceType = 39, 
		RULE_prefixListDefinition = 40, RULE_prefixDeclaration = 41, RULE_brandingListDefinition = 42, 
		RULE_brandingDefinition = 43, RULE_globalRules = 44, RULE_globalRulesDefinition = 45, 
		RULE_acronymTypographyRule = 46, RULE_acronymTypography = 47;
	public static final String[] ruleNames = {
		"file", "subspeciesRule", "typeRule", "methodRule", "referenceRule", "labelRule", 
		"typeRuleDefinition", "methodRuleDefinition", "referenceRuleDefinition", 
		"labelRuleDefinition", "typographyDefinition", "bodyDefinition", "firstCharDefinition", 
		"prefixDefinition", "separatorDefinition", "pluralDefinition", "cipherDefinition", 
		"lengthTokenDefinition", "lengthCharacterDefinition", "typeContentDefinition", 
		"methodContentDefinition", "referenceContentDefinition", "labelContentDefinition", 
		"typeContentSetting", "methodContentSetting", "referenceContentSetting", 
		"labelContentSetting", "bodyValue", "firstCharValue", "standaloneAbbreviation", 
		"typeAcronym", "phraseValue", "prefixValue", "separatorValue", "listDefinition", 
		"cipherListDefinition", "cipherDeclaration", "javaTypeName", "typeWildcardName", 
		"classOrInterfaceType", "prefixListDefinition", "prefixDeclaration", "brandingListDefinition", 
		"brandingDefinition", "globalRules", "globalRulesDefinition", "acronymTypographyRule", 
		"acronymTypography"
	};

	@Override
	public String getGrammarFileName() { return "Nominal.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public NominalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public GlobalRulesContext globalRules() {
			return getRuleContext(GlobalRulesContext.class,0);
		}
		public ListDefinitionContext listDefinition() {
			return getRuleContext(ListDefinitionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(NominalParser.EOF, 0); }
		public List<SubspeciesRuleContext> subspeciesRule() {
			return getRuleContexts(SubspeciesRuleContext.class);
		}
		public SubspeciesRuleContext subspeciesRule(int i) {
			return getRuleContext(SubspeciesRuleContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(96); subspeciesRule();
				}
				}
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_SELECTOR) | (1L << METHOD_SELECTOR) | (1L << REFERENCE_SELECTOR) | (1L << LABEL_SELECTOR))) != 0) );
			setState(101); listDefinition();
			setState(102); globalRules();
			setState(103); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubspeciesRuleContext extends ParserRuleContext {
		public LabelRuleContext labelRule() {
			return getRuleContext(LabelRuleContext.class,0);
		}
		public ReferenceRuleContext referenceRule() {
			return getRuleContext(ReferenceRuleContext.class,0);
		}
		public MethodRuleContext methodRule() {
			return getRuleContext(MethodRuleContext.class,0);
		}
		public TypeRuleContext typeRule() {
			return getRuleContext(TypeRuleContext.class,0);
		}
		public SubspeciesRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subspeciesRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitSubspeciesRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubspeciesRuleContext subspeciesRule() throws RecognitionException {
		SubspeciesRuleContext _localctx = new SubspeciesRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_subspeciesRule);
		try {
			setState(109);
			switch (_input.LA(1)) {
			case TYPE_SELECTOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(105); typeRule();
				}
				break;
			case METHOD_SELECTOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(106); methodRule();
				}
				break;
			case REFERENCE_SELECTOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(107); referenceRule();
				}
				break;
			case LABEL_SELECTOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(108); labelRule();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeRuleContext extends ParserRuleContext {
		public TypeRuleDefinitionContext typeRuleDefinition(int i) {
			return getRuleContext(TypeRuleDefinitionContext.class,i);
		}
		public TerminalNode TYPE_SELECTOR() { return getToken(NominalParser.TYPE_SELECTOR, 0); }
		public List<TypeRuleDefinitionContext> typeRuleDefinition() {
			return getRuleContexts(TypeRuleDefinitionContext.class);
		}
		public TypeRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitTypeRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRuleContext typeRule() throws RecognitionException {
		TypeRuleContext _localctx = new TypeRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(TYPE_SELECTOR);
			setState(112); match(BLOCK_OPEN);
			setState(114); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(113); typeRuleDefinition();
				}
				}
				setState(116); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BODY) | (1L << CONTENT) | (1L << PLURAL) | (1L << FIRST_CHAR) | (1L << PREFIX) | (1L << SEPARATOR))) != 0) );
			setState(118); match(BLOCK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodRuleContext extends ParserRuleContext {
		public MethodRuleDefinitionContext methodRuleDefinition(int i) {
			return getRuleContext(MethodRuleDefinitionContext.class,i);
		}
		public List<MethodRuleDefinitionContext> methodRuleDefinition() {
			return getRuleContexts(MethodRuleDefinitionContext.class);
		}
		public TerminalNode METHOD_SELECTOR() { return getToken(NominalParser.METHOD_SELECTOR, 0); }
		public MethodRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitMethodRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodRuleContext methodRule() throws RecognitionException {
		MethodRuleContext _localctx = new MethodRuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_methodRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(METHOD_SELECTOR);
			setState(121); match(BLOCK_OPEN);
			setState(123); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(122); methodRuleDefinition();
				}
				}
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BODY) | (1L << CONTENT) | (1L << PLURAL) | (1L << FIRST_CHAR) | (1L << PREFIX) | (1L << SEPARATOR))) != 0) );
			setState(127); match(BLOCK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceRuleContext extends ParserRuleContext {
		public ReferenceRuleDefinitionContext referenceRuleDefinition(int i) {
			return getRuleContext(ReferenceRuleDefinitionContext.class,i);
		}
		public List<ReferenceRuleDefinitionContext> referenceRuleDefinition() {
			return getRuleContexts(ReferenceRuleDefinitionContext.class);
		}
		public TerminalNode REFERENCE_SELECTOR() { return getToken(NominalParser.REFERENCE_SELECTOR, 0); }
		public ReferenceRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitReferenceRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceRuleContext referenceRule() throws RecognitionException {
		ReferenceRuleContext _localctx = new ReferenceRuleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_referenceRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(REFERENCE_SELECTOR);
			setState(130); match(BLOCK_OPEN);
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(131); referenceRuleDefinition();
				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BODY) | (1L << CONTENT) | (1L << PLURAL) | (1L << FIRST_CHAR) | (1L << PREFIX) | (1L << SEPARATOR))) != 0) );
			setState(136); match(BLOCK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelRuleContext extends ParserRuleContext {
		public List<LabelRuleDefinitionContext> labelRuleDefinition() {
			return getRuleContexts(LabelRuleDefinitionContext.class);
		}
		public LabelRuleDefinitionContext labelRuleDefinition(int i) {
			return getRuleContext(LabelRuleDefinitionContext.class,i);
		}
		public TerminalNode LABEL_SELECTOR() { return getToken(NominalParser.LABEL_SELECTOR, 0); }
		public LabelRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitLabelRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelRuleContext labelRule() throws RecognitionException {
		LabelRuleContext _localctx = new LabelRuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_labelRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(LABEL_SELECTOR);
			setState(139); match(BLOCK_OPEN);
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140); labelRuleDefinition();
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BODY) | (1L << CONTENT) | (1L << FIRST_CHAR) | (1L << PREFIX) | (1L << SEPARATOR))) != 0) );
			setState(145); match(BLOCK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeRuleDefinitionContext extends ParserRuleContext {
		public PluralDefinitionContext pluralDefinition() {
			return getRuleContext(PluralDefinitionContext.class,0);
		}
		public TypographyDefinitionContext typographyDefinition() {
			return getRuleContext(TypographyDefinitionContext.class,0);
		}
		public TypeContentDefinitionContext typeContentDefinition() {
			return getRuleContext(TypeContentDefinitionContext.class,0);
		}
		public TypeRuleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRuleDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitTypeRuleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRuleDefinitionContext typeRuleDefinition() throws RecognitionException {
		TypeRuleDefinitionContext _localctx = new TypeRuleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typeRuleDefinition);
		try {
			setState(150);
			switch (_input.LA(1)) {
			case BODY:
			case FIRST_CHAR:
			case PREFIX:
			case SEPARATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(147); typographyDefinition();
				}
				break;
			case PLURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(148); pluralDefinition();
				}
				break;
			case CONTENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(149); typeContentDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodRuleDefinitionContext extends ParserRuleContext {
		public PluralDefinitionContext pluralDefinition() {
			return getRuleContext(PluralDefinitionContext.class,0);
		}
		public TypographyDefinitionContext typographyDefinition() {
			return getRuleContext(TypographyDefinitionContext.class,0);
		}
		public MethodContentDefinitionContext methodContentDefinition() {
			return getRuleContext(MethodContentDefinitionContext.class,0);
		}
		public MethodRuleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodRuleDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitMethodRuleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodRuleDefinitionContext methodRuleDefinition() throws RecognitionException {
		MethodRuleDefinitionContext _localctx = new MethodRuleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodRuleDefinition);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case BODY:
			case FIRST_CHAR:
			case PREFIX:
			case SEPARATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(152); typographyDefinition();
				}
				break;
			case PLURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(153); pluralDefinition();
				}
				break;
			case CONTENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(154); methodContentDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceRuleDefinitionContext extends ParserRuleContext {
		public PluralDefinitionContext pluralDefinition() {
			return getRuleContext(PluralDefinitionContext.class,0);
		}
		public TypographyDefinitionContext typographyDefinition() {
			return getRuleContext(TypographyDefinitionContext.class,0);
		}
		public ReferenceContentDefinitionContext referenceContentDefinition() {
			return getRuleContext(ReferenceContentDefinitionContext.class,0);
		}
		public ReferenceRuleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceRuleDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitReferenceRuleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceRuleDefinitionContext referenceRuleDefinition() throws RecognitionException {
		ReferenceRuleDefinitionContext _localctx = new ReferenceRuleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_referenceRuleDefinition);
		try {
			setState(160);
			switch (_input.LA(1)) {
			case BODY:
			case FIRST_CHAR:
			case PREFIX:
			case SEPARATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(157); typographyDefinition();
				}
				break;
			case PLURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(158); pluralDefinition();
				}
				break;
			case CONTENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(159); referenceContentDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelRuleDefinitionContext extends ParserRuleContext {
		public TypographyDefinitionContext typographyDefinition() {
			return getRuleContext(TypographyDefinitionContext.class,0);
		}
		public LabelContentDefinitionContext labelContentDefinition() {
			return getRuleContext(LabelContentDefinitionContext.class,0);
		}
		public LabelRuleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelRuleDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitLabelRuleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelRuleDefinitionContext labelRuleDefinition() throws RecognitionException {
		LabelRuleDefinitionContext _localctx = new LabelRuleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_labelRuleDefinition);
		try {
			setState(164);
			switch (_input.LA(1)) {
			case BODY:
			case FIRST_CHAR:
			case PREFIX:
			case SEPARATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); typographyDefinition();
				}
				break;
			case CONTENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(163); labelContentDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypographyDefinitionContext extends ParserRuleContext {
		public BodyDefinitionContext bodyDefinition() {
			return getRuleContext(BodyDefinitionContext.class,0);
		}
		public PrefixDefinitionContext prefixDefinition() {
			return getRuleContext(PrefixDefinitionContext.class,0);
		}
		public SeparatorDefinitionContext separatorDefinition() {
			return getRuleContext(SeparatorDefinitionContext.class,0);
		}
		public FirstCharDefinitionContext firstCharDefinition() {
			return getRuleContext(FirstCharDefinitionContext.class,0);
		}
		public TypographyDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typographyDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitTypographyDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypographyDefinitionContext typographyDefinition() throws RecognitionException {
		TypographyDefinitionContext _localctx = new TypographyDefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typographyDefinition);
		try {
			setState(170);
			switch (_input.LA(1)) {
			case BODY:
				enterOuterAlt(_localctx, 1);
				{
				setState(166); bodyDefinition();
				}
				break;
			case FIRST_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(167); firstCharDefinition();
				}
				break;
			case PREFIX:
				enterOuterAlt(_localctx, 3);
				{
				setState(168); prefixDefinition();
				}
				break;
			case SEPARATOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(169); separatorDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyDefinitionContext extends ParserRuleContext {
		public BodyValueContext bodyValue() {
			return getRuleContext(BodyValueContext.class,0);
		}
		public BodyDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitBodyDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyDefinitionContext bodyDefinition() throws RecognitionException {
		BodyDefinitionContext _localctx = new BodyDefinitionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bodyDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(BODY);
			setState(173); match(COLON);
			setState(174); bodyValue();
			setState(175); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FirstCharDefinitionContext extends ParserRuleContext {
		public FirstCharValueContext firstCharValue() {
			return getRuleContext(FirstCharValueContext.class,0);
		}
		public FirstCharDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_firstCharDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitFirstCharDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FirstCharDefinitionContext firstCharDefinition() throws RecognitionException {
		FirstCharDefinitionContext _localctx = new FirstCharDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_firstCharDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(FIRST_CHAR);
			setState(178); match(COLON);
			setState(179); firstCharValue();
			setState(180); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixDefinitionContext extends ParserRuleContext {
		public PrefixValueContext prefixValue() {
			return getRuleContext(PrefixValueContext.class,0);
		}
		public PrefixDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitPrefixDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixDefinitionContext prefixDefinition() throws RecognitionException {
		PrefixDefinitionContext _localctx = new PrefixDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_prefixDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); match(PREFIX);
			setState(183); match(COLON);
			setState(184); prefixValue();
			setState(185); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeparatorDefinitionContext extends ParserRuleContext {
		public SeparatorValueContext separatorValue() {
			return getRuleContext(SeparatorValueContext.class,0);
		}
		public SeparatorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_separatorDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitSeparatorDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeparatorDefinitionContext separatorDefinition() throws RecognitionException {
		SeparatorDefinitionContext _localctx = new SeparatorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_separatorDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); match(SEPARATOR);
			setState(188); match(COLON);
			setState(189); separatorValue();
			setState(190); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PluralDefinitionContext extends ParserRuleContext {
		public TerminalNode BooleanValue() { return getToken(NominalParser.BooleanValue, 0); }
		public PluralDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pluralDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitPluralDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PluralDefinitionContext pluralDefinition() throws RecognitionException {
		PluralDefinitionContext _localctx = new PluralDefinitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pluralDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); match(PLURAL);
			setState(193); match(COLON);
			setState(194); match(BooleanValue);
			setState(195); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CipherDefinitionContext extends ParserRuleContext {
		public TerminalNode ListIdentifier() { return getToken(NominalParser.ListIdentifier, 0); }
		public CipherDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cipherDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitCipherDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CipherDefinitionContext cipherDefinition() throws RecognitionException {
		CipherDefinitionContext _localctx = new CipherDefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cipherDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(CIPHER);
			setState(199);
			_la = _input.LA(1);
			if (_la==ListIdentifier) {
				{
				setState(198); match(ListIdentifier);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LengthTokenDefinitionContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(NominalParser.Number, 0); }
		public LengthTokenDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lengthTokenDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitLengthTokenDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LengthTokenDefinitionContext lengthTokenDefinition() throws RecognitionException {
		LengthTokenDefinitionContext _localctx = new LengthTokenDefinitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_lengthTokenDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); match(LENGTH_TOKEN);
			setState(202); match(COLON);
			setState(203); match(Number);
			setState(204); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LengthCharacterDefinitionContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(NominalParser.Number, 0); }
		public LengthCharacterDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lengthCharacterDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitLengthCharacterDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LengthCharacterDefinitionContext lengthCharacterDefinition() throws RecognitionException {
		LengthCharacterDefinitionContext _localctx = new LengthCharacterDefinitionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_lengthCharacterDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); match(LENGTH_CHARACTERS);
			setState(207); match(COLON);
			setState(208); match(Number);
			setState(209); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContentDefinitionContext extends ParserRuleContext {
		public TypeContentSettingContext typeContentSetting(int i) {
			return getRuleContext(TypeContentSettingContext.class,i);
		}
		public List<TypeContentSettingContext> typeContentSetting() {
			return getRuleContexts(TypeContentSettingContext.class);
		}
		public TypeContentDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeContentDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitTypeContentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContentDefinitionContext typeContentDefinition() throws RecognitionException {
		TypeContentDefinitionContext _localctx = new TypeContentDefinitionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeContentDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(CONTENT);
			setState(212); match(COLON);
			setState(213); typeContentSetting();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(214); match(COMMA);
				setState(215); typeContentSetting();
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(221); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContentDefinitionContext extends ParserRuleContext {
		public MethodContentSettingContext methodContentSetting(int i) {
			return getRuleContext(MethodContentSettingContext.class,i);
		}
		public List<MethodContentSettingContext> methodContentSetting() {
			return getRuleContexts(MethodContentSettingContext.class);
		}
		public MethodContentDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodContentDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitMethodContentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContentDefinitionContext methodContentDefinition() throws RecognitionException {
		MethodContentDefinitionContext _localctx = new MethodContentDefinitionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_methodContentDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); match(CONTENT);
			setState(224); match(COLON);
			setState(225); methodContentSetting();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(226); match(COMMA);
				setState(227); methodContentSetting();
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(233); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContentDefinitionContext extends ParserRuleContext {
		public List<ReferenceContentSettingContext> referenceContentSetting() {
			return getRuleContexts(ReferenceContentSettingContext.class);
		}
		public ReferenceContentSettingContext referenceContentSetting(int i) {
			return getRuleContext(ReferenceContentSettingContext.class,i);
		}
		public ReferenceContentDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceContentDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitReferenceContentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContentDefinitionContext referenceContentDefinition() throws RecognitionException {
		ReferenceContentDefinitionContext _localctx = new ReferenceContentDefinitionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_referenceContentDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); match(CONTENT);
			setState(236); match(COLON);
			setState(237); referenceContentSetting();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(238); match(COMMA);
				setState(239); referenceContentSetting();
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContentDefinitionContext extends ParserRuleContext {
		public LabelContentSettingContext labelContentSetting(int i) {
			return getRuleContext(LabelContentSettingContext.class,i);
		}
		public List<LabelContentSettingContext> labelContentSetting() {
			return getRuleContexts(LabelContentSettingContext.class);
		}
		public LabelContentDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelContentDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitLabelContentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContentDefinitionContext labelContentDefinition() throws RecognitionException {
		LabelContentDefinitionContext _localctx = new LabelContentDefinitionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_labelContentDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247); match(CONTENT);
			setState(248); match(COLON);
			setState(249); labelContentSetting();
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(250); match(COMMA);
				setState(251); labelContentSetting();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContentSettingContext extends ParserRuleContext {
		public PhraseValueContext phraseValue() {
			return getRuleContext(PhraseValueContext.class,0);
		}
		public TypeContentSettingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeContentSetting; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitTypeContentSetting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContentSettingContext typeContentSetting() throws RecognitionException {
		TypeContentSettingContext _localctx = new TypeContentSettingContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeContentSetting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); phraseValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContentSettingContext extends ParserRuleContext {
		public PhraseValueContext phraseValue() {
			return getRuleContext(PhraseValueContext.class,0);
		}
		public MethodContentSettingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodContentSetting; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitMethodContentSetting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContentSettingContext methodContentSetting() throws RecognitionException {
		MethodContentSettingContext _localctx = new MethodContentSettingContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_methodContentSetting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261); phraseValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContentSettingContext extends ParserRuleContext {
		public CipherDefinitionContext cipherDefinition() {
			return getRuleContext(CipherDefinitionContext.class,0);
		}
		public StandaloneAbbreviationContext standaloneAbbreviation() {
			return getRuleContext(StandaloneAbbreviationContext.class,0);
		}
		public PhraseValueContext phraseValue() {
			return getRuleContext(PhraseValueContext.class,0);
		}
		public TypeAcronymContext typeAcronym() {
			return getRuleContext(TypeAcronymContext.class,0);
		}
		public ReferenceContentSettingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceContentSetting; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitReferenceContentSetting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContentSettingContext referenceContentSetting() throws RecognitionException {
		ReferenceContentSettingContext _localctx = new ReferenceContentSettingContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_referenceContentSetting);
		try {
			setState(267);
			switch (_input.LA(1)) {
			case CIPHER:
				enterOuterAlt(_localctx, 1);
				{
				setState(263); cipherDefinition();
				}
				break;
			case COMPOUND_PHRASE_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(264); phraseValue();
				}
				break;
			case STANDALONE_ABBREVIATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(265); standaloneAbbreviation();
				}
				break;
			case TYPE_ACRONYM:
				enterOuterAlt(_localctx, 4);
				{
				setState(266); typeAcronym();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContentSettingContext extends ParserRuleContext {
		public StandaloneAbbreviationContext standaloneAbbreviation() {
			return getRuleContext(StandaloneAbbreviationContext.class,0);
		}
		public PhraseValueContext phraseValue() {
			return getRuleContext(PhraseValueContext.class,0);
		}
		public LabelContentSettingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelContentSetting; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitLabelContentSetting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContentSettingContext labelContentSetting() throws RecognitionException {
		LabelContentSettingContext _localctx = new LabelContentSettingContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_labelContentSetting);
		try {
			setState(271);
			switch (_input.LA(1)) {
			case COMPOUND_PHRASE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(269); phraseValue();
				}
				break;
			case STANDALONE_ABBREVIATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(270); standaloneAbbreviation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyValueContext extends ParserRuleContext {
		public BodyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitBodyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyValueContext bodyValue() throws RecognitionException {
		BodyValueContext _localctx = new BodyValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_bodyValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIXED) | (1L << LOWER) | (1L << UPPER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FirstCharValueContext extends ParserRuleContext {
		public FirstCharValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_firstCharValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitFirstCharValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FirstCharValueContext firstCharValue() throws RecognitionException {
		FirstCharValueContext _localctx = new FirstCharValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_firstCharValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !(_la==LOWER || _la==UPPER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StandaloneAbbreviationContext extends ParserRuleContext {
		public TerminalNode STANDALONE_ABBREVIATION() { return getToken(NominalParser.STANDALONE_ABBREVIATION, 0); }
		public StandaloneAbbreviationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standaloneAbbreviation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitStandaloneAbbreviation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StandaloneAbbreviationContext standaloneAbbreviation() throws RecognitionException {
		StandaloneAbbreviationContext _localctx = new StandaloneAbbreviationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_standaloneAbbreviation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277); match(STANDALONE_ABBREVIATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeAcronymContext extends ParserRuleContext {
		public TerminalNode TYPE_ACRONYM() { return getToken(NominalParser.TYPE_ACRONYM, 0); }
		public TypeAcronymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeAcronym; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitTypeAcronym(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeAcronymContext typeAcronym() throws RecognitionException {
		TypeAcronymContext _localctx = new TypeAcronymContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_typeAcronym);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279); match(TYPE_ACRONYM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PhraseValueContext extends ParserRuleContext {
		public TerminalNode COMPOUND_PHRASE_NAME() { return getToken(NominalParser.COMPOUND_PHRASE_NAME, 0); }
		public PhraseValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phraseValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitPhraseValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseValueContext phraseValue() throws RecognitionException {
		PhraseValueContext _localctx = new PhraseValueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_phraseValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); match(COMPOUND_PHRASE_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixValueContext extends ParserRuleContext {
		public List<TerminalNode> PREFIX_VALUE() { return getTokens(NominalParser.PREFIX_VALUE); }
		public TerminalNode PREFIX_VALUE(int i) {
			return getToken(NominalParser.PREFIX_VALUE, i);
		}
		public PrefixValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitPrefixValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixValueContext prefixValue() throws RecognitionException {
		PrefixValueContext _localctx = new PrefixValueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_prefixValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); match(PREFIX_VALUE);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(284); match(COMMA);
				setState(285); match(PREFIX_VALUE);
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeparatorValueContext extends ParserRuleContext {
		public List<TerminalNode> SEPARATOR_CHARACTER() { return getTokens(NominalParser.SEPARATOR_CHARACTER); }
		public TerminalNode MULTIPLIER() { return getToken(NominalParser.MULTIPLIER, 0); }
		public TerminalNode SEPARATOR_CHARACTER(int i) {
			return getToken(NominalParser.SEPARATOR_CHARACTER, i);
		}
		public SeparatorValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_separatorValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitSeparatorValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeparatorValueContext separatorValue() throws RecognitionException {
		SeparatorValueContext _localctx = new SeparatorValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_separatorValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); match(SEPARATOR_CHARACTER);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(292); match(COMMA);
				setState(293); match(SEPARATOR_CHARACTER);
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(300);
			_la = _input.LA(1);
			if (_la==MULTIPLIER) {
				{
				setState(299); match(MULTIPLIER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListDefinitionContext extends ParserRuleContext {
		public CipherListDefinitionContext cipherListDefinition(int i) {
			return getRuleContext(CipherListDefinitionContext.class,i);
		}
		public List<CipherListDefinitionContext> cipherListDefinition() {
			return getRuleContexts(CipherListDefinitionContext.class);
		}
		public ListDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitListDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListDefinitionContext listDefinition() throws RecognitionException {
		ListDefinitionContext _localctx = new ListDefinitionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_listDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CIPHER_LIST) {
				{
				{
				setState(302); cipherListDefinition();
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CipherListDefinitionContext extends ParserRuleContext {
		public List<CipherDeclarationContext> cipherDeclaration() {
			return getRuleContexts(CipherDeclarationContext.class);
		}
		public CipherDeclarationContext cipherDeclaration(int i) {
			return getRuleContext(CipherDeclarationContext.class,i);
		}
		public TerminalNode DEFAULT() { return getToken(NominalParser.DEFAULT, 0); }
		public TerminalNode ListIdentifier() { return getToken(NominalParser.ListIdentifier, 0); }
		public CipherListDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cipherListDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitCipherListDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CipherListDefinitionContext cipherListDefinition() throws RecognitionException {
		CipherListDefinitionContext _localctx = new CipherListDefinitionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_cipherListDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); match(CIPHER_LIST);
			setState(309);
			_la = _input.LA(1);
			if ( !(_la==DEFAULT || _la==ListIdentifier) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(310); match(BLOCK_OPEN);
			setState(312); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(311); cipherDeclaration();
				}
				}
				setState(314); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CipherName );
			setState(316); match(BLOCK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CipherDeclarationContext extends ParserRuleContext {
		public List<JavaTypeNameContext> javaTypeName() {
			return getRuleContexts(JavaTypeNameContext.class);
		}
		public JavaTypeNameContext javaTypeName(int i) {
			return getRuleContext(JavaTypeNameContext.class,i);
		}
		public List<TerminalNode> CipherName() { return getTokens(NominalParser.CipherName); }
		public TerminalNode CipherName(int i) {
			return getToken(NominalParser.CipherName, i);
		}
		public CipherDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cipherDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitCipherDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CipherDeclarationContext cipherDeclaration() throws RecognitionException {
		CipherDeclarationContext _localctx = new CipherDeclarationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_cipherDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); match(CipherName);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(319); match(COMMA);
				setState(320); match(CipherName);
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(326); match(COLON);
			setState(327); javaTypeName();
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(328); match(COMMA);
				setState(329); javaTypeName();
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JavaTypeNameContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeWildcardNameContext typeWildcardName() {
			return getRuleContext(TypeWildcardNameContext.class,0);
		}
		public TerminalNode PRIMITIVE_TYPE() { return getToken(NominalParser.PRIMITIVE_TYPE, 0); }
		public JavaTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_javaTypeName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitJavaTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JavaTypeNameContext javaTypeName() throws RecognitionException {
		JavaTypeNameContext _localctx = new JavaTypeNameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_javaTypeName);
		try {
			setState(340);
			switch (_input.LA(1)) {
			case SEMI_COLON:
			case COMMA:
			case JavaIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(337); classOrInterfaceType();
				}
				break;
			case PRIMITIVE_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(338); match(PRIMITIVE_TYPE);
				}
				break;
			case WILDCARD:
				enterOuterAlt(_localctx, 3);
				{
				setState(339); typeWildcardName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeWildcardNameContext extends ParserRuleContext {
		public TerminalNode JavaIdentifier() { return getToken(NominalParser.JavaIdentifier, 0); }
		public TerminalNode WILDCARD() { return getToken(NominalParser.WILDCARD, 0); }
		public TypeWildcardNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeWildcardName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitTypeWildcardName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeWildcardNameContext typeWildcardName() throws RecognitionException {
		TypeWildcardNameContext _localctx = new TypeWildcardNameContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_typeWildcardName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342); match(WILDCARD);
			setState(344);
			_la = _input.LA(1);
			if (_la==JavaIdentifier) {
				{
				setState(343); match(JavaIdentifier);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode JavaIdentifier(int i) {
			return getToken(NominalParser.JavaIdentifier, i);
		}
		public List<TerminalNode> JavaIdentifier() { return getTokens(NominalParser.JavaIdentifier); }
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_classOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==JavaIdentifier) {
				{
				{
				setState(346); match(JavaIdentifier);
				}
				}
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixListDefinitionContext extends ParserRuleContext {
		public PrefixDeclarationContext prefixDeclaration(int i) {
			return getRuleContext(PrefixDeclarationContext.class,i);
		}
		public TerminalNode ListIdentifier() { return getToken(NominalParser.ListIdentifier, 0); }
		public List<PrefixDeclarationContext> prefixDeclaration() {
			return getRuleContexts(PrefixDeclarationContext.class);
		}
		public PrefixListDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixListDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitPrefixListDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixListDefinitionContext prefixListDefinition() throws RecognitionException {
		PrefixListDefinitionContext _localctx = new PrefixListDefinitionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_prefixListDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352); match(PREFIX_LIST);
			setState(353); match(ListIdentifier);
			setState(354); match(BLOCK_OPEN);
			setState(356); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(355); prefixDeclaration();
				}
				}
				setState(358); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==JavaIdentifier );
			setState(360); match(BLOCK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixDeclarationContext extends ParserRuleContext {
		public List<JavaTypeNameContext> javaTypeName() {
			return getRuleContexts(JavaTypeNameContext.class);
		}
		public TerminalNode JavaIdentifier() { return getToken(NominalParser.JavaIdentifier, 0); }
		public JavaTypeNameContext javaTypeName(int i) {
			return getRuleContext(JavaTypeNameContext.class,i);
		}
		public PrefixDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitPrefixDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixDeclarationContext prefixDeclaration() throws RecognitionException {
		PrefixDeclarationContext _localctx = new PrefixDeclarationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_prefixDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362); match(JavaIdentifier);
			setState(363); match(COLON);
			setState(364); javaTypeName();
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(365); match(COMMA);
				setState(366); javaTypeName();
				}
				}
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(372); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BrandingListDefinitionContext extends ParserRuleContext {
		public List<BrandingDefinitionContext> brandingDefinition() {
			return getRuleContexts(BrandingDefinitionContext.class);
		}
		public TerminalNode DEFAULT() { return getToken(NominalParser.DEFAULT, 0); }
		public BrandingDefinitionContext brandingDefinition(int i) {
			return getRuleContext(BrandingDefinitionContext.class,i);
		}
		public TerminalNode ListIdentifier() { return getToken(NominalParser.ListIdentifier, 0); }
		public BrandingListDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brandingListDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitBrandingListDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BrandingListDefinitionContext brandingListDefinition() throws RecognitionException {
		BrandingListDefinitionContext _localctx = new BrandingListDefinitionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_brandingListDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374); match(BRANDING_LIST);
			setState(375);
			_la = _input.LA(1);
			if ( !(_la==DEFAULT || _la==ListIdentifier) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(376); match(BLOCK_OPEN);
			setState(378); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(377); brandingDefinition();
				}
				}
				setState(380); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==BRAND );
			setState(382); match(BLOCK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BrandingDefinitionContext extends ParserRuleContext {
		public TerminalNode JavaIdentifier() { return getToken(NominalParser.JavaIdentifier, 0); }
		public BrandingDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brandingDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitBrandingDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BrandingDefinitionContext brandingDefinition() throws RecognitionException {
		BrandingDefinitionContext _localctx = new BrandingDefinitionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_brandingDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384); match(BRAND);
			setState(385); match(COLON);
			setState(386); match(JavaIdentifier);
			setState(387); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalRulesContext extends ParserRuleContext {
		public GlobalRulesDefinitionContext globalRulesDefinition() {
			return getRuleContext(GlobalRulesDefinitionContext.class,0);
		}
		public GlobalRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalRules; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitGlobalRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalRulesContext globalRules() throws RecognitionException {
		GlobalRulesContext _localctx = new GlobalRulesContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_globalRules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(389); globalRulesDefinition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalRulesDefinitionContext extends ParserRuleContext {
		public AcronymTypographyRuleContext acronymTypographyRule() {
			return getRuleContext(AcronymTypographyRuleContext.class,0);
		}
		public GlobalRulesDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalRulesDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitGlobalRulesDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalRulesDefinitionContext globalRulesDefinition() throws RecognitionException {
		GlobalRulesDefinitionContext _localctx = new GlobalRulesDefinitionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_globalRulesDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392); match(GLOBAL);
			setState(393); match(BLOCK_OPEN);
			setState(394); acronymTypographyRule();
			setState(395); match(BLOCK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AcronymTypographyRuleContext extends ParserRuleContext {
		public AcronymTypographyContext acronymTypography() {
			return getRuleContext(AcronymTypographyContext.class,0);
		}
		public AcronymTypographyRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acronymTypographyRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitAcronymTypographyRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcronymTypographyRuleContext acronymTypographyRule() throws RecognitionException {
		AcronymTypographyRuleContext _localctx = new AcronymTypographyRuleContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_acronymTypographyRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397); match(ACRONYMS);
			setState(398); match(COLON);
			setState(399); acronymTypography();
			setState(400); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AcronymTypographyContext extends ParserRuleContext {
		public AcronymTypographyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acronymTypography; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NominalVisitor ) return ((NominalVisitor<? extends T>)visitor).visitAcronymTypography(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcronymTypographyContext acronymTypography() throws RecognitionException {
		AcronymTypographyContext _localctx = new AcronymTypographyContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_acronymTypography);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			_la = _input.LA(1);
			if ( !(_la==MIXED || _la==UPPER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\39\u0197\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\6\2d\n\2\r\2\16\2e\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3p\n\3\3\4\3\4\3\4\6\4u\n\4\r\4\16\4v\3"+
		"\4\3\4\3\5\3\5\3\5\6\5~\n\5\r\5\16\5\177\3\5\3\5\3\6\3\6\3\6\6\6\u0087"+
		"\n\6\r\6\16\6\u0088\3\6\3\6\3\7\3\7\3\7\6\7\u0090\n\7\r\7\16\7\u0091\3"+
		"\7\3\7\3\b\3\b\3\b\5\b\u0099\n\b\3\t\3\t\3\t\5\t\u009e\n\t\3\n\3\n\3\n"+
		"\5\n\u00a3\n\n\3\13\3\13\5\13\u00a7\n\13\3\f\3\f\3\f\3\f\5\f\u00ad\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00ca"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\7\25\u00db\n\25\f\25\16\25\u00de\13\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\7\26\u00e7\n\26\f\26\16\26\u00ea\13\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\7\27\u00f3\n\27\f\27\16\27\u00f6\13\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\7\30\u00ff\n\30\f\30\16\30\u0102\13\30\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\5\33\u010e\n\33\3\34\3\34"+
		"\5\34\u0112\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\""+
		"\7\"\u0121\n\"\f\"\16\"\u0124\13\"\3#\3#\3#\7#\u0129\n#\f#\16#\u012c\13"+
		"#\3#\5#\u012f\n#\3$\7$\u0132\n$\f$\16$\u0135\13$\3%\3%\3%\3%\6%\u013b"+
		"\n%\r%\16%\u013c\3%\3%\3&\3&\3&\7&\u0144\n&\f&\16&\u0147\13&\3&\3&\3&"+
		"\3&\7&\u014d\n&\f&\16&\u0150\13&\3&\3&\3\'\3\'\3\'\5\'\u0157\n\'\3(\3"+
		"(\5(\u015b\n(\3)\7)\u015e\n)\f)\16)\u0161\13)\3*\3*\3*\3*\6*\u0167\n*"+
		"\r*\16*\u0168\3*\3*\3+\3+\3+\3+\3+\7+\u0172\n+\f+\16+\u0175\13+\3+\3+"+
		"\3,\3,\3,\3,\6,\u017d\n,\r,\16,\u017e\3,\3,\3-\3-\3-\3-\3-\3.\5.\u0189"+
		"\n.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\2\62\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`\2\6\3\2#%\3\2$%\4\2\17\17\64\64\4\2##%%\u0190\2c\3\2\2\2\4o\3"+
		"\2\2\2\6q\3\2\2\2\bz\3\2\2\2\n\u0083\3\2\2\2\f\u008c\3\2\2\2\16\u0098"+
		"\3\2\2\2\20\u009d\3\2\2\2\22\u00a2\3\2\2\2\24\u00a6\3\2\2\2\26\u00ac\3"+
		"\2\2\2\30\u00ae\3\2\2\2\32\u00b3\3\2\2\2\34\u00b8\3\2\2\2\36\u00bd\3\2"+
		"\2\2 \u00c2\3\2\2\2\"\u00c7\3\2\2\2$\u00cb\3\2\2\2&\u00d0\3\2\2\2(\u00d5"+
		"\3\2\2\2*\u00e1\3\2\2\2,\u00ed\3\2\2\2.\u00f9\3\2\2\2\60\u0105\3\2\2\2"+
		"\62\u0107\3\2\2\2\64\u010d\3\2\2\2\66\u0111\3\2\2\28\u0113\3\2\2\2:\u0115"+
		"\3\2\2\2<\u0117\3\2\2\2>\u0119\3\2\2\2@\u011b\3\2\2\2B\u011d\3\2\2\2D"+
		"\u0125\3\2\2\2F\u0133\3\2\2\2H\u0136\3\2\2\2J\u0140\3\2\2\2L\u0156\3\2"+
		"\2\2N\u0158\3\2\2\2P\u015f\3\2\2\2R\u0162\3\2\2\2T\u016c\3\2\2\2V\u0178"+
		"\3\2\2\2X\u0182\3\2\2\2Z\u0188\3\2\2\2\\\u018a\3\2\2\2^\u018f\3\2\2\2"+
		"`\u0194\3\2\2\2bd\5\4\3\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3"+
		"\2\2\2gh\5F$\2hi\5Z.\2ij\7\2\2\3j\3\3\2\2\2kp\5\6\4\2lp\5\b\5\2mp\5\n"+
		"\6\2np\5\f\7\2ok\3\2\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2p\5\3\2\2\2qr\7"+
		"\3\2\2rt\7/\2\2su\5\16\b\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wx\3"+
		"\2\2\2xy\7\60\2\2y\7\3\2\2\2z{\7\4\2\2{}\7/\2\2|~\5\20\t\2}|\3\2\2\2~"+
		"\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\7\60\2\2\u0082\t\3\2\2\2\u0083\u0084\7\5\2\2\u0084\u0086\7/\2\2"+
		"\u0085\u0087\5\22\n\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\7\60\2\2"+
		"\u008b\13\3\2\2\2\u008c\u008d\7\6\2\2\u008d\u008f\7/\2\2\u008e\u0090\5"+
		"\24\13\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\60\2\2\u0094\r\3\2\2"+
		"\2\u0095\u0099\5\26\f\2\u0096\u0099\5 \21\2\u0097\u0099\5(\25\2\u0098"+
		"\u0095\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\17\3\2\2"+
		"\2\u009a\u009e\5\26\f\2\u009b\u009e\5 \21\2\u009c\u009e\5*\26\2\u009d"+
		"\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\21\3\2\2"+
		"\2\u009f\u00a3\5\26\f\2\u00a0\u00a3\5 \21\2\u00a1\u00a3\5,\27\2\u00a2"+
		"\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\23\3\2\2"+
		"\2\u00a4\u00a7\5\26\f\2\u00a5\u00a7\5.\30\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a5\3\2\2\2\u00a7\25\3\2\2\2\u00a8\u00ad\5\30\r\2\u00a9\u00ad\5\32"+
		"\16\2\u00aa\u00ad\5\34\17\2\u00ab\u00ad\5\36\20\2\u00ac\u00a8\3\2\2\2"+
		"\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\27"+
		"\3\2\2\2\u00ae\u00af\7\13\2\2\u00af\u00b0\7(\2\2\u00b0\u00b1\58\35\2\u00b1"+
		"\u00b2\7)\2\2\u00b2\31\3\2\2\2\u00b3\u00b4\7\22\2\2\u00b4\u00b5\7(\2\2"+
		"\u00b5\u00b6\5:\36\2\u00b6\u00b7\7)\2\2\u00b7\33\3\2\2\2\u00b8\u00b9\7"+
		"\26\2\2\u00b9\u00ba\7(\2\2\u00ba\u00bb\5B\"\2\u00bb\u00bc\7)\2\2\u00bc"+
		"\35\3\2\2\2\u00bd\u00be\7\30\2\2\u00be\u00bf\7(\2\2\u00bf\u00c0\5D#\2"+
		"\u00c0\u00c1\7)\2\2\u00c1\37\3\2\2\2\u00c2\u00c3\7\21\2\2\u00c3\u00c4"+
		"\7(\2\2\u00c4\u00c5\7!\2\2\u00c5\u00c6\7)\2\2\u00c6!\3\2\2\2\u00c7\u00c9"+
		"\7\r\2\2\u00c8\u00ca\7\64\2\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2"+
		"\u00ca#\3\2\2\2\u00cb\u00cc\7\24\2\2\u00cc\u00cd\7(\2\2\u00cd\u00ce\7"+
		"\67\2\2\u00ce\u00cf\7)\2\2\u00cf%\3\2\2\2\u00d0\u00d1\7\23\2\2\u00d1\u00d2"+
		"\7(\2\2\u00d2\u00d3\7\67\2\2\u00d3\u00d4\7)\2\2\u00d4\'\3\2\2\2\u00d5"+
		"\u00d6\7\16\2\2\u00d6\u00d7\7(\2\2\u00d7\u00dc\5\60\31\2\u00d8\u00d9\7"+
		"*\2\2\u00d9\u00db\5\60\31\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00dc\3\2"+
		"\2\2\u00df\u00e0\7)\2\2\u00e0)\3\2\2\2\u00e1\u00e2\7\16\2\2\u00e2\u00e3"+
		"\7(\2\2\u00e3\u00e8\5\62\32\2\u00e4\u00e5\7*\2\2\u00e5\u00e7\5\62\32\2"+
		"\u00e6\u00e4\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7)\2\2\u00ec"+
		"+\3\2\2\2\u00ed\u00ee\7\16\2\2\u00ee\u00ef\7(\2\2\u00ef\u00f4\5\64\33"+
		"\2\u00f0\u00f1\7*\2\2\u00f1\u00f3\5\64\33\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2"+
		"\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\7)\2\2\u00f8-\3\2\2\2\u00f9\u00fa"+
		"\7\16\2\2\u00fa\u00fb\7(\2\2\u00fb\u0100\5\66\34\2\u00fc\u00fd\7*\2\2"+
		"\u00fd\u00ff\5\66\34\2\u00fe\u00fc\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe"+
		"\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103"+
		"\u0104\7)\2\2\u0104/\3\2\2\2\u0105\u0106\5@!\2\u0106\61\3\2\2\2\u0107"+
		"\u0108\5@!\2\u0108\63\3\2\2\2\u0109\u010e\5\"\22\2\u010a\u010e\5@!\2\u010b"+
		"\u010e\5<\37\2\u010c\u010e\5> \2\u010d\u0109\3\2\2\2\u010d\u010a\3\2\2"+
		"\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\65\3\2\2\2\u010f\u0112"+
		"\5@!\2\u0110\u0112\5<\37\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112"+
		"\67\3\2\2\2\u0113\u0114\t\2\2\2\u01149\3\2\2\2\u0115\u0116\t\3\2\2\u0116"+
		";\3\2\2\2\u0117\u0118\7\31\2\2\u0118=\3\2\2\2\u0119\u011a\7\32\2\2\u011a"+
		"?\3\2\2\2\u011b\u011c\7\33\2\2\u011cA\3\2\2\2\u011d\u0122\7\66\2\2\u011e"+
		"\u011f\7*\2\2\u011f\u0121\7\66\2\2\u0120\u011e\3\2\2\2\u0121\u0124\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123C\3\2\2\2\u0124\u0122"+
		"\3\2\2\2\u0125\u012a\7\35\2\2\u0126\u0127\7*\2\2\u0127\u0129\7\35\2\2"+
		"\u0128\u0126\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b"+
		"\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012f\7\61\2\2"+
		"\u012e\u012d\3\2\2\2\u012e\u012f\3\2\2\2\u012fE\3\2\2\2\u0130\u0132\5"+
		"H%\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134G\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\7 \2\2\u0137"+
		"\u0138\t\4\2\2\u0138\u013a\7/\2\2\u0139\u013b\5J&\2\u013a\u0139\3\2\2"+
		"\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e"+
		"\3\2\2\2\u013e\u013f\7\60\2\2\u013fI\3\2\2\2\u0140\u0145\7\63\2\2\u0141"+
		"\u0142\7*\2\2\u0142\u0144\7\63\2\2\u0143\u0141\3\2\2\2\u0144\u0147\3\2"+
		"\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0148\u0149\7(\2\2\u0149\u014e\5L\'\2\u014a\u014b\7*\2"+
		"\2\u014b\u014d\5L\'\2\u014c\u014a\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c"+
		"\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151"+
		"\u0152\7)\2\2\u0152K\3\2\2\2\u0153\u0157\5P)\2\u0154\u0157\7\37\2\2\u0155"+
		"\u0157\5N(\2\u0156\u0153\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2"+
		"\2\u0157M\3\2\2\2\u0158\u015a\7\62\2\2\u0159\u015b\7\65\2\2\u015a\u0159"+
		"\3\2\2\2\u015a\u015b\3\2\2\2\u015bO\3\2\2\2\u015c\u015e\7\65\2\2\u015d"+
		"\u015c\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2"+
		"\2\2\u0160Q\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163\7\27\2\2\u0163\u0164"+
		"\7\64\2\2\u0164\u0166\7/\2\2\u0165\u0167\5T+\2\u0166\u0165\3\2\2\2\u0167"+
		"\u0168\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\3\2"+
		"\2\2\u016a\u016b\7\60\2\2\u016bS\3\2\2\2\u016c\u016d\7\65\2\2\u016d\u016e"+
		"\7(\2\2\u016e\u0173\5L\'\2\u016f\u0170\7*\2\2\u0170\u0172\5L\'\2\u0171"+
		"\u016f\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2"+
		"\2\2\u0174\u0176\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0177\7)\2\2\u0177"+
		"U\3\2\2\2\u0178\u0179\7\n\2\2\u0179\u017a\t\4\2\2\u017a\u017c\7/\2\2\u017b"+
		"\u017d\5X-\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017c\3\2\2"+
		"\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\7\60\2\2\u0181"+
		"W\3\2\2\2\u0182\u0183\7\f\2\2\u0183\u0184\7(\2\2\u0184\u0185\7\65\2\2"+
		"\u0185\u0186\7)\2\2\u0186Y\3\2\2\2\u0187\u0189\5\\/\2\u0188\u0187\3\2"+
		"\2\2\u0188\u0189\3\2\2\2\u0189[\3\2\2\2\u018a\u018b\7\20\2\2\u018b\u018c"+
		"\7/\2\2\u018c\u018d\5^\60\2\u018d\u018e\7\60\2\2\u018e]\3\2\2\2\u018f"+
		"\u0190\7\t\2\2\u0190\u0191\7(\2\2\u0191\u0192\5`\61\2\u0192\u0193\7)\2"+
		"\2\u0193_\3\2\2\2\u0194\u0195\t\5\2\2\u0195a\3\2\2\2\"eov\177\u0088\u0091"+
		"\u0098\u009d\u00a2\u00a6\u00ac\u00c9\u00dc\u00e8\u00f4\u0100\u010d\u0111"+
		"\u0122\u012a\u012e\u0133\u013c\u0145\u014e\u0156\u015a\u015f\u0168\u0173"+
		"\u017e\u0188";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}