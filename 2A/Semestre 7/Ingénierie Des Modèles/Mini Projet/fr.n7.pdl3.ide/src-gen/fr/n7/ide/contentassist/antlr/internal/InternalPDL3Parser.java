package fr.n7.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import fr.n7.services.PDL3GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPDL3Parser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'s2s'", "'f2s'", "'s2f'", "'f2f'", "'process :'", "'workdefinitions :'", "'worksequences :'", "';'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalPDL3Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPDL3Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPDL3Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalPDL3.g"; }


    	private PDL3GrammarAccess grammarAccess;

    	public void setGrammarAccess(PDL3GrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleProcess"
    // InternalPDL3.g:53:1: entryRuleProcess : ruleProcess EOF ;
    public final void entryRuleProcess() throws RecognitionException {
        try {
            // InternalPDL3.g:54:1: ( ruleProcess EOF )
            // InternalPDL3.g:55:1: ruleProcess EOF
            {
             before(grammarAccess.getProcessRule()); 
            pushFollow(FOLLOW_1);
            ruleProcess();

            state._fsp--;

             after(grammarAccess.getProcessRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalPDL3.g:62:1: ruleProcess : ( ( rule__Process__Group__0 ) ) ;
    public final void ruleProcess() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:66:2: ( ( ( rule__Process__Group__0 ) ) )
            // InternalPDL3.g:67:2: ( ( rule__Process__Group__0 ) )
            {
            // InternalPDL3.g:67:2: ( ( rule__Process__Group__0 ) )
            // InternalPDL3.g:68:3: ( rule__Process__Group__0 )
            {
             before(grammarAccess.getProcessAccess().getGroup()); 
            // InternalPDL3.g:69:3: ( rule__Process__Group__0 )
            // InternalPDL3.g:69:4: rule__Process__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleWorkDefinition"
    // InternalPDL3.g:78:1: entryRuleWorkDefinition : ruleWorkDefinition EOF ;
    public final void entryRuleWorkDefinition() throws RecognitionException {
        try {
            // InternalPDL3.g:79:1: ( ruleWorkDefinition EOF )
            // InternalPDL3.g:80:1: ruleWorkDefinition EOF
            {
             before(grammarAccess.getWorkDefinitionRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkDefinition();

            state._fsp--;

             after(grammarAccess.getWorkDefinitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkDefinition"


    // $ANTLR start "ruleWorkDefinition"
    // InternalPDL3.g:87:1: ruleWorkDefinition : ( ( rule__WorkDefinition__Group__0 ) ) ;
    public final void ruleWorkDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:91:2: ( ( ( rule__WorkDefinition__Group__0 ) ) )
            // InternalPDL3.g:92:2: ( ( rule__WorkDefinition__Group__0 ) )
            {
            // InternalPDL3.g:92:2: ( ( rule__WorkDefinition__Group__0 ) )
            // InternalPDL3.g:93:3: ( rule__WorkDefinition__Group__0 )
            {
             before(grammarAccess.getWorkDefinitionAccess().getGroup()); 
            // InternalPDL3.g:94:3: ( rule__WorkDefinition__Group__0 )
            // InternalPDL3.g:94:4: rule__WorkDefinition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorkDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkDefinition"


    // $ANTLR start "entryRuleWorkSequence"
    // InternalPDL3.g:103:1: entryRuleWorkSequence : ruleWorkSequence EOF ;
    public final void entryRuleWorkSequence() throws RecognitionException {
        try {
            // InternalPDL3.g:104:1: ( ruleWorkSequence EOF )
            // InternalPDL3.g:105:1: ruleWorkSequence EOF
            {
             before(grammarAccess.getWorkSequenceRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkSequence();

            state._fsp--;

             after(grammarAccess.getWorkSequenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkSequence"


    // $ANTLR start "ruleWorkSequence"
    // InternalPDL3.g:112:1: ruleWorkSequence : ( ( rule__WorkSequence__Group__0 ) ) ;
    public final void ruleWorkSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:116:2: ( ( ( rule__WorkSequence__Group__0 ) ) )
            // InternalPDL3.g:117:2: ( ( rule__WorkSequence__Group__0 ) )
            {
            // InternalPDL3.g:117:2: ( ( rule__WorkSequence__Group__0 ) )
            // InternalPDL3.g:118:3: ( rule__WorkSequence__Group__0 )
            {
             before(grammarAccess.getWorkSequenceAccess().getGroup()); 
            // InternalPDL3.g:119:3: ( rule__WorkSequence__Group__0 )
            // InternalPDL3.g:119:4: rule__WorkSequence__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkSequence"


    // $ANTLR start "ruleWorkSequenceType"
    // InternalPDL3.g:128:1: ruleWorkSequenceType : ( ( rule__WorkSequenceType__Alternatives ) ) ;
    public final void ruleWorkSequenceType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:132:1: ( ( ( rule__WorkSequenceType__Alternatives ) ) )
            // InternalPDL3.g:133:2: ( ( rule__WorkSequenceType__Alternatives ) )
            {
            // InternalPDL3.g:133:2: ( ( rule__WorkSequenceType__Alternatives ) )
            // InternalPDL3.g:134:3: ( rule__WorkSequenceType__Alternatives )
            {
             before(grammarAccess.getWorkSequenceTypeAccess().getAlternatives()); 
            // InternalPDL3.g:135:3: ( rule__WorkSequenceType__Alternatives )
            // InternalPDL3.g:135:4: rule__WorkSequenceType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequenceType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkSequenceType"


    // $ANTLR start "rule__WorkSequenceType__Alternatives"
    // InternalPDL3.g:143:1: rule__WorkSequenceType__Alternatives : ( ( ( 's2s' ) ) | ( ( 'f2s' ) ) | ( ( 's2f' ) ) | ( ( 'f2f' ) ) );
    public final void rule__WorkSequenceType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:147:1: ( ( ( 's2s' ) ) | ( ( 'f2s' ) ) | ( ( 's2f' ) ) | ( ( 'f2f' ) ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalPDL3.g:148:2: ( ( 's2s' ) )
                    {
                    // InternalPDL3.g:148:2: ( ( 's2s' ) )
                    // InternalPDL3.g:149:3: ( 's2s' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0()); 
                    // InternalPDL3.g:150:3: ( 's2s' )
                    // InternalPDL3.g:150:4: 's2s'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPDL3.g:154:2: ( ( 'f2s' ) )
                    {
                    // InternalPDL3.g:154:2: ( ( 'f2s' ) )
                    // InternalPDL3.g:155:3: ( 'f2s' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1()); 
                    // InternalPDL3.g:156:3: ( 'f2s' )
                    // InternalPDL3.g:156:4: 'f2s'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPDL3.g:160:2: ( ( 's2f' ) )
                    {
                    // InternalPDL3.g:160:2: ( ( 's2f' ) )
                    // InternalPDL3.g:161:3: ( 's2f' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2()); 
                    // InternalPDL3.g:162:3: ( 's2f' )
                    // InternalPDL3.g:162:4: 's2f'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPDL3.g:166:2: ( ( 'f2f' ) )
                    {
                    // InternalPDL3.g:166:2: ( ( 'f2f' ) )
                    // InternalPDL3.g:167:3: ( 'f2f' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getFinish2finishEnumLiteralDeclaration_3()); 
                    // InternalPDL3.g:168:3: ( 'f2f' )
                    // InternalPDL3.g:168:4: 'f2f'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getFinish2finishEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequenceType__Alternatives"


    // $ANTLR start "rule__Process__Group__0"
    // InternalPDL3.g:176:1: rule__Process__Group__0 : rule__Process__Group__0__Impl rule__Process__Group__1 ;
    public final void rule__Process__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:180:1: ( rule__Process__Group__0__Impl rule__Process__Group__1 )
            // InternalPDL3.g:181:2: rule__Process__Group__0__Impl rule__Process__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Process__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__0"


    // $ANTLR start "rule__Process__Group__0__Impl"
    // InternalPDL3.g:188:1: rule__Process__Group__0__Impl : ( 'process :' ) ;
    public final void rule__Process__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:192:1: ( ( 'process :' ) )
            // InternalPDL3.g:193:1: ( 'process :' )
            {
            // InternalPDL3.g:193:1: ( 'process :' )
            // InternalPDL3.g:194:2: 'process :'
            {
             before(grammarAccess.getProcessAccess().getProcessKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getProcessKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__0__Impl"


    // $ANTLR start "rule__Process__Group__1"
    // InternalPDL3.g:203:1: rule__Process__Group__1 : rule__Process__Group__1__Impl rule__Process__Group__2 ;
    public final void rule__Process__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:207:1: ( rule__Process__Group__1__Impl rule__Process__Group__2 )
            // InternalPDL3.g:208:2: rule__Process__Group__1__Impl rule__Process__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Process__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__1"


    // $ANTLR start "rule__Process__Group__1__Impl"
    // InternalPDL3.g:215:1: rule__Process__Group__1__Impl : ( ( rule__Process__NameAssignment_1 ) ) ;
    public final void rule__Process__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:219:1: ( ( ( rule__Process__NameAssignment_1 ) ) )
            // InternalPDL3.g:220:1: ( ( rule__Process__NameAssignment_1 ) )
            {
            // InternalPDL3.g:220:1: ( ( rule__Process__NameAssignment_1 ) )
            // InternalPDL3.g:221:2: ( rule__Process__NameAssignment_1 )
            {
             before(grammarAccess.getProcessAccess().getNameAssignment_1()); 
            // InternalPDL3.g:222:2: ( rule__Process__NameAssignment_1 )
            // InternalPDL3.g:222:3: rule__Process__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__1__Impl"


    // $ANTLR start "rule__Process__Group__2"
    // InternalPDL3.g:230:1: rule__Process__Group__2 : rule__Process__Group__2__Impl rule__Process__Group__3 ;
    public final void rule__Process__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:234:1: ( rule__Process__Group__2__Impl rule__Process__Group__3 )
            // InternalPDL3.g:235:2: rule__Process__Group__2__Impl rule__Process__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__2"


    // $ANTLR start "rule__Process__Group__2__Impl"
    // InternalPDL3.g:242:1: rule__Process__Group__2__Impl : ( 'workdefinitions :' ) ;
    public final void rule__Process__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:246:1: ( ( 'workdefinitions :' ) )
            // InternalPDL3.g:247:1: ( 'workdefinitions :' )
            {
            // InternalPDL3.g:247:1: ( 'workdefinitions :' )
            // InternalPDL3.g:248:2: 'workdefinitions :'
            {
             before(grammarAccess.getProcessAccess().getWorkdefinitionsKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getWorkdefinitionsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__2__Impl"


    // $ANTLR start "rule__Process__Group__3"
    // InternalPDL3.g:257:1: rule__Process__Group__3 : rule__Process__Group__3__Impl rule__Process__Group__4 ;
    public final void rule__Process__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:261:1: ( rule__Process__Group__3__Impl rule__Process__Group__4 )
            // InternalPDL3.g:262:2: rule__Process__Group__3__Impl rule__Process__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__3"


    // $ANTLR start "rule__Process__Group__3__Impl"
    // InternalPDL3.g:269:1: rule__Process__Group__3__Impl : ( ( rule__Process__WorkDefinitionAssignment_3 )* ) ;
    public final void rule__Process__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:273:1: ( ( ( rule__Process__WorkDefinitionAssignment_3 )* ) )
            // InternalPDL3.g:274:1: ( ( rule__Process__WorkDefinitionAssignment_3 )* )
            {
            // InternalPDL3.g:274:1: ( ( rule__Process__WorkDefinitionAssignment_3 )* )
            // InternalPDL3.g:275:2: ( rule__Process__WorkDefinitionAssignment_3 )*
            {
             before(grammarAccess.getProcessAccess().getWorkDefinitionAssignment_3()); 
            // InternalPDL3.g:276:2: ( rule__Process__WorkDefinitionAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPDL3.g:276:3: rule__Process__WorkDefinitionAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Process__WorkDefinitionAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getWorkDefinitionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__3__Impl"


    // $ANTLR start "rule__Process__Group__4"
    // InternalPDL3.g:284:1: rule__Process__Group__4 : rule__Process__Group__4__Impl rule__Process__Group__5 ;
    public final void rule__Process__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:288:1: ( rule__Process__Group__4__Impl rule__Process__Group__5 )
            // InternalPDL3.g:289:2: rule__Process__Group__4__Impl rule__Process__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Process__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__4"


    // $ANTLR start "rule__Process__Group__4__Impl"
    // InternalPDL3.g:296:1: rule__Process__Group__4__Impl : ( 'worksequences :' ) ;
    public final void rule__Process__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:300:1: ( ( 'worksequences :' ) )
            // InternalPDL3.g:301:1: ( 'worksequences :' )
            {
            // InternalPDL3.g:301:1: ( 'worksequences :' )
            // InternalPDL3.g:302:2: 'worksequences :'
            {
             before(grammarAccess.getProcessAccess().getWorksequencesKeyword_4()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getWorksequencesKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__4__Impl"


    // $ANTLR start "rule__Process__Group__5"
    // InternalPDL3.g:311:1: rule__Process__Group__5 : rule__Process__Group__5__Impl ;
    public final void rule__Process__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:315:1: ( rule__Process__Group__5__Impl )
            // InternalPDL3.g:316:2: rule__Process__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__5"


    // $ANTLR start "rule__Process__Group__5__Impl"
    // InternalPDL3.g:322:1: rule__Process__Group__5__Impl : ( ( rule__Process__WorkSequenceAssignment_5 )* ) ;
    public final void rule__Process__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:326:1: ( ( ( rule__Process__WorkSequenceAssignment_5 )* ) )
            // InternalPDL3.g:327:1: ( ( rule__Process__WorkSequenceAssignment_5 )* )
            {
            // InternalPDL3.g:327:1: ( ( rule__Process__WorkSequenceAssignment_5 )* )
            // InternalPDL3.g:328:2: ( rule__Process__WorkSequenceAssignment_5 )*
            {
             before(grammarAccess.getProcessAccess().getWorkSequenceAssignment_5()); 
            // InternalPDL3.g:329:2: ( rule__Process__WorkSequenceAssignment_5 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPDL3.g:329:3: rule__Process__WorkSequenceAssignment_5
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Process__WorkSequenceAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getWorkSequenceAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__5__Impl"


    // $ANTLR start "rule__WorkDefinition__Group__0"
    // InternalPDL3.g:338:1: rule__WorkDefinition__Group__0 : rule__WorkDefinition__Group__0__Impl rule__WorkDefinition__Group__1 ;
    public final void rule__WorkDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:342:1: ( rule__WorkDefinition__Group__0__Impl rule__WorkDefinition__Group__1 )
            // InternalPDL3.g:343:2: rule__WorkDefinition__Group__0__Impl rule__WorkDefinition__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__WorkDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__0"


    // $ANTLR start "rule__WorkDefinition__Group__0__Impl"
    // InternalPDL3.g:350:1: rule__WorkDefinition__Group__0__Impl : ( ( rule__WorkDefinition__NameAssignment_0 ) ) ;
    public final void rule__WorkDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:354:1: ( ( ( rule__WorkDefinition__NameAssignment_0 ) ) )
            // InternalPDL3.g:355:1: ( ( rule__WorkDefinition__NameAssignment_0 ) )
            {
            // InternalPDL3.g:355:1: ( ( rule__WorkDefinition__NameAssignment_0 ) )
            // InternalPDL3.g:356:2: ( rule__WorkDefinition__NameAssignment_0 )
            {
             before(grammarAccess.getWorkDefinitionAccess().getNameAssignment_0()); 
            // InternalPDL3.g:357:2: ( rule__WorkDefinition__NameAssignment_0 )
            // InternalPDL3.g:357:3: rule__WorkDefinition__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getWorkDefinitionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__0__Impl"


    // $ANTLR start "rule__WorkDefinition__Group__1"
    // InternalPDL3.g:365:1: rule__WorkDefinition__Group__1 : rule__WorkDefinition__Group__1__Impl ;
    public final void rule__WorkDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:369:1: ( rule__WorkDefinition__Group__1__Impl )
            // InternalPDL3.g:370:2: rule__WorkDefinition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__1"


    // $ANTLR start "rule__WorkDefinition__Group__1__Impl"
    // InternalPDL3.g:376:1: rule__WorkDefinition__Group__1__Impl : ( ';' ) ;
    public final void rule__WorkDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:380:1: ( ( ';' ) )
            // InternalPDL3.g:381:1: ( ';' )
            {
            // InternalPDL3.g:381:1: ( ';' )
            // InternalPDL3.g:382:2: ';'
            {
             before(grammarAccess.getWorkDefinitionAccess().getSemicolonKeyword_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getWorkDefinitionAccess().getSemicolonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__1__Impl"


    // $ANTLR start "rule__WorkSequence__Group__0"
    // InternalPDL3.g:392:1: rule__WorkSequence__Group__0 : rule__WorkSequence__Group__0__Impl rule__WorkSequence__Group__1 ;
    public final void rule__WorkSequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:396:1: ( rule__WorkSequence__Group__0__Impl rule__WorkSequence__Group__1 )
            // InternalPDL3.g:397:2: rule__WorkSequence__Group__0__Impl rule__WorkSequence__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__WorkSequence__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__0"


    // $ANTLR start "rule__WorkSequence__Group__0__Impl"
    // InternalPDL3.g:404:1: rule__WorkSequence__Group__0__Impl : ( ( rule__WorkSequence__PredecessorAssignment_0 ) ) ;
    public final void rule__WorkSequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:408:1: ( ( ( rule__WorkSequence__PredecessorAssignment_0 ) ) )
            // InternalPDL3.g:409:1: ( ( rule__WorkSequence__PredecessorAssignment_0 ) )
            {
            // InternalPDL3.g:409:1: ( ( rule__WorkSequence__PredecessorAssignment_0 ) )
            // InternalPDL3.g:410:2: ( rule__WorkSequence__PredecessorAssignment_0 )
            {
             before(grammarAccess.getWorkSequenceAccess().getPredecessorAssignment_0()); 
            // InternalPDL3.g:411:2: ( rule__WorkSequence__PredecessorAssignment_0 )
            // InternalPDL3.g:411:3: rule__WorkSequence__PredecessorAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__PredecessorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getPredecessorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__0__Impl"


    // $ANTLR start "rule__WorkSequence__Group__1"
    // InternalPDL3.g:419:1: rule__WorkSequence__Group__1 : rule__WorkSequence__Group__1__Impl rule__WorkSequence__Group__2 ;
    public final void rule__WorkSequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:423:1: ( rule__WorkSequence__Group__1__Impl rule__WorkSequence__Group__2 )
            // InternalPDL3.g:424:2: rule__WorkSequence__Group__1__Impl rule__WorkSequence__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__WorkSequence__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__1"


    // $ANTLR start "rule__WorkSequence__Group__1__Impl"
    // InternalPDL3.g:431:1: rule__WorkSequence__Group__1__Impl : ( ( rule__WorkSequence__LinkTypeAssignment_1 ) ) ;
    public final void rule__WorkSequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:435:1: ( ( ( rule__WorkSequence__LinkTypeAssignment_1 ) ) )
            // InternalPDL3.g:436:1: ( ( rule__WorkSequence__LinkTypeAssignment_1 ) )
            {
            // InternalPDL3.g:436:1: ( ( rule__WorkSequence__LinkTypeAssignment_1 ) )
            // InternalPDL3.g:437:2: ( rule__WorkSequence__LinkTypeAssignment_1 )
            {
             before(grammarAccess.getWorkSequenceAccess().getLinkTypeAssignment_1()); 
            // InternalPDL3.g:438:2: ( rule__WorkSequence__LinkTypeAssignment_1 )
            // InternalPDL3.g:438:3: rule__WorkSequence__LinkTypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__LinkTypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getLinkTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__1__Impl"


    // $ANTLR start "rule__WorkSequence__Group__2"
    // InternalPDL3.g:446:1: rule__WorkSequence__Group__2 : rule__WorkSequence__Group__2__Impl rule__WorkSequence__Group__3 ;
    public final void rule__WorkSequence__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:450:1: ( rule__WorkSequence__Group__2__Impl rule__WorkSequence__Group__3 )
            // InternalPDL3.g:451:2: rule__WorkSequence__Group__2__Impl rule__WorkSequence__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__WorkSequence__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__2"


    // $ANTLR start "rule__WorkSequence__Group__2__Impl"
    // InternalPDL3.g:458:1: rule__WorkSequence__Group__2__Impl : ( ( rule__WorkSequence__SuccessorAssignment_2 ) ) ;
    public final void rule__WorkSequence__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:462:1: ( ( ( rule__WorkSequence__SuccessorAssignment_2 ) ) )
            // InternalPDL3.g:463:1: ( ( rule__WorkSequence__SuccessorAssignment_2 ) )
            {
            // InternalPDL3.g:463:1: ( ( rule__WorkSequence__SuccessorAssignment_2 ) )
            // InternalPDL3.g:464:2: ( rule__WorkSequence__SuccessorAssignment_2 )
            {
             before(grammarAccess.getWorkSequenceAccess().getSuccessorAssignment_2()); 
            // InternalPDL3.g:465:2: ( rule__WorkSequence__SuccessorAssignment_2 )
            // InternalPDL3.g:465:3: rule__WorkSequence__SuccessorAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__SuccessorAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getSuccessorAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__2__Impl"


    // $ANTLR start "rule__WorkSequence__Group__3"
    // InternalPDL3.g:473:1: rule__WorkSequence__Group__3 : rule__WorkSequence__Group__3__Impl ;
    public final void rule__WorkSequence__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:477:1: ( rule__WorkSequence__Group__3__Impl )
            // InternalPDL3.g:478:2: rule__WorkSequence__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__3"


    // $ANTLR start "rule__WorkSequence__Group__3__Impl"
    // InternalPDL3.g:484:1: rule__WorkSequence__Group__3__Impl : ( ';' ) ;
    public final void rule__WorkSequence__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:488:1: ( ( ';' ) )
            // InternalPDL3.g:489:1: ( ';' )
            {
            // InternalPDL3.g:489:1: ( ';' )
            // InternalPDL3.g:490:2: ';'
            {
             before(grammarAccess.getWorkSequenceAccess().getSemicolonKeyword_3()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__3__Impl"


    // $ANTLR start "rule__Process__NameAssignment_1"
    // InternalPDL3.g:500:1: rule__Process__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Process__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:504:1: ( ( RULE_ID ) )
            // InternalPDL3.g:505:2: ( RULE_ID )
            {
            // InternalPDL3.g:505:2: ( RULE_ID )
            // InternalPDL3.g:506:3: RULE_ID
            {
             before(grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__NameAssignment_1"


    // $ANTLR start "rule__Process__WorkDefinitionAssignment_3"
    // InternalPDL3.g:515:1: rule__Process__WorkDefinitionAssignment_3 : ( ruleWorkDefinition ) ;
    public final void rule__Process__WorkDefinitionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:519:1: ( ( ruleWorkDefinition ) )
            // InternalPDL3.g:520:2: ( ruleWorkDefinition )
            {
            // InternalPDL3.g:520:2: ( ruleWorkDefinition )
            // InternalPDL3.g:521:3: ruleWorkDefinition
            {
             before(grammarAccess.getProcessAccess().getWorkDefinitionWorkDefinitionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkDefinition();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getWorkDefinitionWorkDefinitionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__WorkDefinitionAssignment_3"


    // $ANTLR start "rule__Process__WorkSequenceAssignment_5"
    // InternalPDL3.g:530:1: rule__Process__WorkSequenceAssignment_5 : ( ruleWorkSequence ) ;
    public final void rule__Process__WorkSequenceAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:534:1: ( ( ruleWorkSequence ) )
            // InternalPDL3.g:535:2: ( ruleWorkSequence )
            {
            // InternalPDL3.g:535:2: ( ruleWorkSequence )
            // InternalPDL3.g:536:3: ruleWorkSequence
            {
             before(grammarAccess.getProcessAccess().getWorkSequenceWorkSequenceParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkSequence();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getWorkSequenceWorkSequenceParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__WorkSequenceAssignment_5"


    // $ANTLR start "rule__WorkDefinition__NameAssignment_0"
    // InternalPDL3.g:545:1: rule__WorkDefinition__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__WorkDefinition__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:549:1: ( ( RULE_ID ) )
            // InternalPDL3.g:550:2: ( RULE_ID )
            {
            // InternalPDL3.g:550:2: ( RULE_ID )
            // InternalPDL3.g:551:3: RULE_ID
            {
             before(grammarAccess.getWorkDefinitionAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWorkDefinitionAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__NameAssignment_0"


    // $ANTLR start "rule__WorkSequence__PredecessorAssignment_0"
    // InternalPDL3.g:560:1: rule__WorkSequence__PredecessorAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__WorkSequence__PredecessorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:564:1: ( ( ( RULE_ID ) ) )
            // InternalPDL3.g:565:2: ( ( RULE_ID ) )
            {
            // InternalPDL3.g:565:2: ( ( RULE_ID ) )
            // InternalPDL3.g:566:3: ( RULE_ID )
            {
             before(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionCrossReference_0_0()); 
            // InternalPDL3.g:567:3: ( RULE_ID )
            // InternalPDL3.g:568:4: RULE_ID
            {
             before(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__PredecessorAssignment_0"


    // $ANTLR start "rule__WorkSequence__LinkTypeAssignment_1"
    // InternalPDL3.g:579:1: rule__WorkSequence__LinkTypeAssignment_1 : ( ruleWorkSequenceType ) ;
    public final void rule__WorkSequence__LinkTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:583:1: ( ( ruleWorkSequenceType ) )
            // InternalPDL3.g:584:2: ( ruleWorkSequenceType )
            {
            // InternalPDL3.g:584:2: ( ruleWorkSequenceType )
            // InternalPDL3.g:585:3: ruleWorkSequenceType
            {
             before(grammarAccess.getWorkSequenceAccess().getLinkTypeWorkSequenceTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkSequenceType();

            state._fsp--;

             after(grammarAccess.getWorkSequenceAccess().getLinkTypeWorkSequenceTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__LinkTypeAssignment_1"


    // $ANTLR start "rule__WorkSequence__SuccessorAssignment_2"
    // InternalPDL3.g:594:1: rule__WorkSequence__SuccessorAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__WorkSequence__SuccessorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL3.g:598:1: ( ( ( RULE_ID ) ) )
            // InternalPDL3.g:599:2: ( ( RULE_ID ) )
            {
            // InternalPDL3.g:599:2: ( ( RULE_ID ) )
            // InternalPDL3.g:600:3: ( RULE_ID )
            {
             before(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionCrossReference_2_0()); 
            // InternalPDL3.g:601:3: ( RULE_ID )
            // InternalPDL3.g:602:4: RULE_ID
            {
             before(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__SuccessorAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000007800L});

}