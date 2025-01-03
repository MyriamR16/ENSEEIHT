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
import fr.n7.services.PDL1GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPDL1Parser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'s2s'", "'f2s'", "'s2f'", "'f2f'", "'process'", "'{'", "'}'", "'wd'", "'ws'", "'from'", "'to'", "'note'", "'ress'", "'occ'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalPDL1Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPDL1Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPDL1Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalPDL1.g"; }


    	private PDL1GrammarAccess grammarAccess;

    	public void setGrammarAccess(PDL1GrammarAccess grammarAccess) {
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
    // InternalPDL1.g:53:1: entryRuleProcess : ruleProcess EOF ;
    public final void entryRuleProcess() throws RecognitionException {
        try {
            // InternalPDL1.g:54:1: ( ruleProcess EOF )
            // InternalPDL1.g:55:1: ruleProcess EOF
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
    // InternalPDL1.g:62:1: ruleProcess : ( ( rule__Process__Group__0 ) ) ;
    public final void ruleProcess() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:66:2: ( ( ( rule__Process__Group__0 ) ) )
            // InternalPDL1.g:67:2: ( ( rule__Process__Group__0 ) )
            {
            // InternalPDL1.g:67:2: ( ( rule__Process__Group__0 ) )
            // InternalPDL1.g:68:3: ( rule__Process__Group__0 )
            {
             before(grammarAccess.getProcessAccess().getGroup()); 
            // InternalPDL1.g:69:3: ( rule__Process__Group__0 )
            // InternalPDL1.g:69:4: rule__Process__Group__0
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


    // $ANTLR start "entryRuleProcessElement"
    // InternalPDL1.g:78:1: entryRuleProcessElement : ruleProcessElement EOF ;
    public final void entryRuleProcessElement() throws RecognitionException {
        try {
            // InternalPDL1.g:79:1: ( ruleProcessElement EOF )
            // InternalPDL1.g:80:1: ruleProcessElement EOF
            {
             before(grammarAccess.getProcessElementRule()); 
            pushFollow(FOLLOW_1);
            ruleProcessElement();

            state._fsp--;

             after(grammarAccess.getProcessElementRule()); 
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
    // $ANTLR end "entryRuleProcessElement"


    // $ANTLR start "ruleProcessElement"
    // InternalPDL1.g:87:1: ruleProcessElement : ( ( rule__ProcessElement__Alternatives ) ) ;
    public final void ruleProcessElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:91:2: ( ( ( rule__ProcessElement__Alternatives ) ) )
            // InternalPDL1.g:92:2: ( ( rule__ProcessElement__Alternatives ) )
            {
            // InternalPDL1.g:92:2: ( ( rule__ProcessElement__Alternatives ) )
            // InternalPDL1.g:93:3: ( rule__ProcessElement__Alternatives )
            {
             before(grammarAccess.getProcessElementAccess().getAlternatives()); 
            // InternalPDL1.g:94:3: ( rule__ProcessElement__Alternatives )
            // InternalPDL1.g:94:4: rule__ProcessElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ProcessElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getProcessElementAccess().getAlternatives()); 

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
    // $ANTLR end "ruleProcessElement"


    // $ANTLR start "entryRuleWorkDefinition"
    // InternalPDL1.g:103:1: entryRuleWorkDefinition : ruleWorkDefinition EOF ;
    public final void entryRuleWorkDefinition() throws RecognitionException {
        try {
            // InternalPDL1.g:104:1: ( ruleWorkDefinition EOF )
            // InternalPDL1.g:105:1: ruleWorkDefinition EOF
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
    // InternalPDL1.g:112:1: ruleWorkDefinition : ( ( rule__WorkDefinition__Group__0 ) ) ;
    public final void ruleWorkDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:116:2: ( ( ( rule__WorkDefinition__Group__0 ) ) )
            // InternalPDL1.g:117:2: ( ( rule__WorkDefinition__Group__0 ) )
            {
            // InternalPDL1.g:117:2: ( ( rule__WorkDefinition__Group__0 ) )
            // InternalPDL1.g:118:3: ( rule__WorkDefinition__Group__0 )
            {
             before(grammarAccess.getWorkDefinitionAccess().getGroup()); 
            // InternalPDL1.g:119:3: ( rule__WorkDefinition__Group__0 )
            // InternalPDL1.g:119:4: rule__WorkDefinition__Group__0
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
    // InternalPDL1.g:128:1: entryRuleWorkSequence : ruleWorkSequence EOF ;
    public final void entryRuleWorkSequence() throws RecognitionException {
        try {
            // InternalPDL1.g:129:1: ( ruleWorkSequence EOF )
            // InternalPDL1.g:130:1: ruleWorkSequence EOF
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
    // InternalPDL1.g:137:1: ruleWorkSequence : ( ( rule__WorkSequence__Group__0 ) ) ;
    public final void ruleWorkSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:141:2: ( ( ( rule__WorkSequence__Group__0 ) ) )
            // InternalPDL1.g:142:2: ( ( rule__WorkSequence__Group__0 ) )
            {
            // InternalPDL1.g:142:2: ( ( rule__WorkSequence__Group__0 ) )
            // InternalPDL1.g:143:3: ( rule__WorkSequence__Group__0 )
            {
             before(grammarAccess.getWorkSequenceAccess().getGroup()); 
            // InternalPDL1.g:144:3: ( rule__WorkSequence__Group__0 )
            // InternalPDL1.g:144:4: rule__WorkSequence__Group__0
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


    // $ANTLR start "entryRuleGuidance"
    // InternalPDL1.g:153:1: entryRuleGuidance : ruleGuidance EOF ;
    public final void entryRuleGuidance() throws RecognitionException {
        try {
            // InternalPDL1.g:154:1: ( ruleGuidance EOF )
            // InternalPDL1.g:155:1: ruleGuidance EOF
            {
             before(grammarAccess.getGuidanceRule()); 
            pushFollow(FOLLOW_1);
            ruleGuidance();

            state._fsp--;

             after(grammarAccess.getGuidanceRule()); 
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
    // $ANTLR end "entryRuleGuidance"


    // $ANTLR start "ruleGuidance"
    // InternalPDL1.g:162:1: ruleGuidance : ( ( rule__Guidance__Group__0 ) ) ;
    public final void ruleGuidance() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:166:2: ( ( ( rule__Guidance__Group__0 ) ) )
            // InternalPDL1.g:167:2: ( ( rule__Guidance__Group__0 ) )
            {
            // InternalPDL1.g:167:2: ( ( rule__Guidance__Group__0 ) )
            // InternalPDL1.g:168:3: ( rule__Guidance__Group__0 )
            {
             before(grammarAccess.getGuidanceAccess().getGroup()); 
            // InternalPDL1.g:169:3: ( rule__Guidance__Group__0 )
            // InternalPDL1.g:169:4: rule__Guidance__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Guidance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGuidanceAccess().getGroup()); 

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
    // $ANTLR end "ruleGuidance"


    // $ANTLR start "entryRuleRessource"
    // InternalPDL1.g:178:1: entryRuleRessource : ruleRessource EOF ;
    public final void entryRuleRessource() throws RecognitionException {
        try {
            // InternalPDL1.g:179:1: ( ruleRessource EOF )
            // InternalPDL1.g:180:1: ruleRessource EOF
            {
             before(grammarAccess.getRessourceRule()); 
            pushFollow(FOLLOW_1);
            ruleRessource();

            state._fsp--;

             after(grammarAccess.getRessourceRule()); 
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
    // $ANTLR end "entryRuleRessource"


    // $ANTLR start "ruleRessource"
    // InternalPDL1.g:187:1: ruleRessource : ( ( rule__Ressource__Group__0 ) ) ;
    public final void ruleRessource() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:191:2: ( ( ( rule__Ressource__Group__0 ) ) )
            // InternalPDL1.g:192:2: ( ( rule__Ressource__Group__0 ) )
            {
            // InternalPDL1.g:192:2: ( ( rule__Ressource__Group__0 ) )
            // InternalPDL1.g:193:3: ( rule__Ressource__Group__0 )
            {
             before(grammarAccess.getRessourceAccess().getGroup()); 
            // InternalPDL1.g:194:3: ( rule__Ressource__Group__0 )
            // InternalPDL1.g:194:4: rule__Ressource__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Ressource__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRessourceAccess().getGroup()); 

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
    // $ANTLR end "ruleRessource"


    // $ANTLR start "entryRuleOccurrence"
    // InternalPDL1.g:203:1: entryRuleOccurrence : ruleOccurrence EOF ;
    public final void entryRuleOccurrence() throws RecognitionException {
        try {
            // InternalPDL1.g:204:1: ( ruleOccurrence EOF )
            // InternalPDL1.g:205:1: ruleOccurrence EOF
            {
             before(grammarAccess.getOccurrenceRule()); 
            pushFollow(FOLLOW_1);
            ruleOccurrence();

            state._fsp--;

             after(grammarAccess.getOccurrenceRule()); 
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
    // $ANTLR end "entryRuleOccurrence"


    // $ANTLR start "ruleOccurrence"
    // InternalPDL1.g:212:1: ruleOccurrence : ( ( rule__Occurrence__Group__0 ) ) ;
    public final void ruleOccurrence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:216:2: ( ( ( rule__Occurrence__Group__0 ) ) )
            // InternalPDL1.g:217:2: ( ( rule__Occurrence__Group__0 ) )
            {
            // InternalPDL1.g:217:2: ( ( rule__Occurrence__Group__0 ) )
            // InternalPDL1.g:218:3: ( rule__Occurrence__Group__0 )
            {
             before(grammarAccess.getOccurrenceAccess().getGroup()); 
            // InternalPDL1.g:219:3: ( rule__Occurrence__Group__0 )
            // InternalPDL1.g:219:4: rule__Occurrence__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Occurrence__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOccurrenceAccess().getGroup()); 

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
    // $ANTLR end "ruleOccurrence"


    // $ANTLR start "ruleWorkSequenceType"
    // InternalPDL1.g:228:1: ruleWorkSequenceType : ( ( rule__WorkSequenceType__Alternatives ) ) ;
    public final void ruleWorkSequenceType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:232:1: ( ( ( rule__WorkSequenceType__Alternatives ) ) )
            // InternalPDL1.g:233:2: ( ( rule__WorkSequenceType__Alternatives ) )
            {
            // InternalPDL1.g:233:2: ( ( rule__WorkSequenceType__Alternatives ) )
            // InternalPDL1.g:234:3: ( rule__WorkSequenceType__Alternatives )
            {
             before(grammarAccess.getWorkSequenceTypeAccess().getAlternatives()); 
            // InternalPDL1.g:235:3: ( rule__WorkSequenceType__Alternatives )
            // InternalPDL1.g:235:4: rule__WorkSequenceType__Alternatives
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


    // $ANTLR start "rule__ProcessElement__Alternatives"
    // InternalPDL1.g:243:1: rule__ProcessElement__Alternatives : ( ( ruleRessource ) | ( ruleWorkDefinition ) | ( ruleWorkSequence ) | ( ruleGuidance ) );
    public final void rule__ProcessElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:247:1: ( ( ruleRessource ) | ( ruleWorkDefinition ) | ( ruleWorkSequence ) | ( ruleGuidance ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 18:
                {
                alt1=2;
                }
                break;
            case 19:
                {
                alt1=3;
                }
                break;
            case 22:
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
                    // InternalPDL1.g:248:2: ( ruleRessource )
                    {
                    // InternalPDL1.g:248:2: ( ruleRessource )
                    // InternalPDL1.g:249:3: ruleRessource
                    {
                     before(grammarAccess.getProcessElementAccess().getRessourceParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleRessource();

                    state._fsp--;

                     after(grammarAccess.getProcessElementAccess().getRessourceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPDL1.g:254:2: ( ruleWorkDefinition )
                    {
                    // InternalPDL1.g:254:2: ( ruleWorkDefinition )
                    // InternalPDL1.g:255:3: ruleWorkDefinition
                    {
                     before(grammarAccess.getProcessElementAccess().getWorkDefinitionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleWorkDefinition();

                    state._fsp--;

                     after(grammarAccess.getProcessElementAccess().getWorkDefinitionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPDL1.g:260:2: ( ruleWorkSequence )
                    {
                    // InternalPDL1.g:260:2: ( ruleWorkSequence )
                    // InternalPDL1.g:261:3: ruleWorkSequence
                    {
                     before(grammarAccess.getProcessElementAccess().getWorkSequenceParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleWorkSequence();

                    state._fsp--;

                     after(grammarAccess.getProcessElementAccess().getWorkSequenceParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPDL1.g:266:2: ( ruleGuidance )
                    {
                    // InternalPDL1.g:266:2: ( ruleGuidance )
                    // InternalPDL1.g:267:3: ruleGuidance
                    {
                     before(grammarAccess.getProcessElementAccess().getGuidanceParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleGuidance();

                    state._fsp--;

                     after(grammarAccess.getProcessElementAccess().getGuidanceParserRuleCall_3()); 

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
    // $ANTLR end "rule__ProcessElement__Alternatives"


    // $ANTLR start "rule__WorkSequenceType__Alternatives"
    // InternalPDL1.g:276:1: rule__WorkSequenceType__Alternatives : ( ( ( 's2s' ) ) | ( ( 'f2s' ) ) | ( ( 's2f' ) ) | ( ( 'f2f' ) ) );
    public final void rule__WorkSequenceType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:280:1: ( ( ( 's2s' ) ) | ( ( 'f2s' ) ) | ( ( 's2f' ) ) | ( ( 'f2f' ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalPDL1.g:281:2: ( ( 's2s' ) )
                    {
                    // InternalPDL1.g:281:2: ( ( 's2s' ) )
                    // InternalPDL1.g:282:3: ( 's2s' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0()); 
                    // InternalPDL1.g:283:3: ( 's2s' )
                    // InternalPDL1.g:283:4: 's2s'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPDL1.g:287:2: ( ( 'f2s' ) )
                    {
                    // InternalPDL1.g:287:2: ( ( 'f2s' ) )
                    // InternalPDL1.g:288:3: ( 'f2s' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1()); 
                    // InternalPDL1.g:289:3: ( 'f2s' )
                    // InternalPDL1.g:289:4: 'f2s'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPDL1.g:293:2: ( ( 's2f' ) )
                    {
                    // InternalPDL1.g:293:2: ( ( 's2f' ) )
                    // InternalPDL1.g:294:3: ( 's2f' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2()); 
                    // InternalPDL1.g:295:3: ( 's2f' )
                    // InternalPDL1.g:295:4: 's2f'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPDL1.g:299:2: ( ( 'f2f' ) )
                    {
                    // InternalPDL1.g:299:2: ( ( 'f2f' ) )
                    // InternalPDL1.g:300:3: ( 'f2f' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getFinish2finishEnumLiteralDeclaration_3()); 
                    // InternalPDL1.g:301:3: ( 'f2f' )
                    // InternalPDL1.g:301:4: 'f2f'
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
    // InternalPDL1.g:309:1: rule__Process__Group__0 : rule__Process__Group__0__Impl rule__Process__Group__1 ;
    public final void rule__Process__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:313:1: ( rule__Process__Group__0__Impl rule__Process__Group__1 )
            // InternalPDL1.g:314:2: rule__Process__Group__0__Impl rule__Process__Group__1
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
    // InternalPDL1.g:321:1: rule__Process__Group__0__Impl : ( 'process' ) ;
    public final void rule__Process__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:325:1: ( ( 'process' ) )
            // InternalPDL1.g:326:1: ( 'process' )
            {
            // InternalPDL1.g:326:1: ( 'process' )
            // InternalPDL1.g:327:2: 'process'
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
    // InternalPDL1.g:336:1: rule__Process__Group__1 : rule__Process__Group__1__Impl rule__Process__Group__2 ;
    public final void rule__Process__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:340:1: ( rule__Process__Group__1__Impl rule__Process__Group__2 )
            // InternalPDL1.g:341:2: rule__Process__Group__1__Impl rule__Process__Group__2
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
    // InternalPDL1.g:348:1: rule__Process__Group__1__Impl : ( ( rule__Process__NameAssignment_1 ) ) ;
    public final void rule__Process__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:352:1: ( ( ( rule__Process__NameAssignment_1 ) ) )
            // InternalPDL1.g:353:1: ( ( rule__Process__NameAssignment_1 ) )
            {
            // InternalPDL1.g:353:1: ( ( rule__Process__NameAssignment_1 ) )
            // InternalPDL1.g:354:2: ( rule__Process__NameAssignment_1 )
            {
             before(grammarAccess.getProcessAccess().getNameAssignment_1()); 
            // InternalPDL1.g:355:2: ( rule__Process__NameAssignment_1 )
            // InternalPDL1.g:355:3: rule__Process__NameAssignment_1
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
    // InternalPDL1.g:363:1: rule__Process__Group__2 : rule__Process__Group__2__Impl rule__Process__Group__3 ;
    public final void rule__Process__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:367:1: ( rule__Process__Group__2__Impl rule__Process__Group__3 )
            // InternalPDL1.g:368:2: rule__Process__Group__2__Impl rule__Process__Group__3
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
    // InternalPDL1.g:375:1: rule__Process__Group__2__Impl : ( '{' ) ;
    public final void rule__Process__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:379:1: ( ( '{' ) )
            // InternalPDL1.g:380:1: ( '{' )
            {
            // InternalPDL1.g:380:1: ( '{' )
            // InternalPDL1.g:381:2: '{'
            {
             before(grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2()); 

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
    // InternalPDL1.g:390:1: rule__Process__Group__3 : rule__Process__Group__3__Impl rule__Process__Group__4 ;
    public final void rule__Process__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:394:1: ( rule__Process__Group__3__Impl rule__Process__Group__4 )
            // InternalPDL1.g:395:2: rule__Process__Group__3__Impl rule__Process__Group__4
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
    // InternalPDL1.g:402:1: rule__Process__Group__3__Impl : ( ( rule__Process__ProcessElementsAssignment_3 )* ) ;
    public final void rule__Process__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:406:1: ( ( ( rule__Process__ProcessElementsAssignment_3 )* ) )
            // InternalPDL1.g:407:1: ( ( rule__Process__ProcessElementsAssignment_3 )* )
            {
            // InternalPDL1.g:407:1: ( ( rule__Process__ProcessElementsAssignment_3 )* )
            // InternalPDL1.g:408:2: ( rule__Process__ProcessElementsAssignment_3 )*
            {
             before(grammarAccess.getProcessAccess().getProcessElementsAssignment_3()); 
            // InternalPDL1.g:409:2: ( rule__Process__ProcessElementsAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=18 && LA3_0<=19)||(LA3_0>=22 && LA3_0<=23)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPDL1.g:409:3: rule__Process__ProcessElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Process__ProcessElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getProcessElementsAssignment_3()); 

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
    // InternalPDL1.g:417:1: rule__Process__Group__4 : rule__Process__Group__4__Impl ;
    public final void rule__Process__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:421:1: ( rule__Process__Group__4__Impl )
            // InternalPDL1.g:422:2: rule__Process__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group__4__Impl();

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
    // InternalPDL1.g:428:1: rule__Process__Group__4__Impl : ( '}' ) ;
    public final void rule__Process__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:432:1: ( ( '}' ) )
            // InternalPDL1.g:433:1: ( '}' )
            {
            // InternalPDL1.g:433:1: ( '}' )
            // InternalPDL1.g:434:2: '}'
            {
             before(grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_4()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_4()); 

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


    // $ANTLR start "rule__WorkDefinition__Group__0"
    // InternalPDL1.g:444:1: rule__WorkDefinition__Group__0 : rule__WorkDefinition__Group__0__Impl rule__WorkDefinition__Group__1 ;
    public final void rule__WorkDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:448:1: ( rule__WorkDefinition__Group__0__Impl rule__WorkDefinition__Group__1 )
            // InternalPDL1.g:449:2: rule__WorkDefinition__Group__0__Impl rule__WorkDefinition__Group__1
            {
            pushFollow(FOLLOW_3);
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
    // InternalPDL1.g:456:1: rule__WorkDefinition__Group__0__Impl : ( 'wd' ) ;
    public final void rule__WorkDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:460:1: ( ( 'wd' ) )
            // InternalPDL1.g:461:1: ( 'wd' )
            {
            // InternalPDL1.g:461:1: ( 'wd' )
            // InternalPDL1.g:462:2: 'wd'
            {
             before(grammarAccess.getWorkDefinitionAccess().getWdKeyword_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getWorkDefinitionAccess().getWdKeyword_0()); 

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
    // InternalPDL1.g:471:1: rule__WorkDefinition__Group__1 : rule__WorkDefinition__Group__1__Impl rule__WorkDefinition__Group__2 ;
    public final void rule__WorkDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:475:1: ( rule__WorkDefinition__Group__1__Impl rule__WorkDefinition__Group__2 )
            // InternalPDL1.g:476:2: rule__WorkDefinition__Group__1__Impl rule__WorkDefinition__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__WorkDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group__2();

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
    // InternalPDL1.g:483:1: rule__WorkDefinition__Group__1__Impl : ( ( rule__WorkDefinition__NameAssignment_1 ) ) ;
    public final void rule__WorkDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:487:1: ( ( ( rule__WorkDefinition__NameAssignment_1 ) ) )
            // InternalPDL1.g:488:1: ( ( rule__WorkDefinition__NameAssignment_1 ) )
            {
            // InternalPDL1.g:488:1: ( ( rule__WorkDefinition__NameAssignment_1 ) )
            // InternalPDL1.g:489:2: ( rule__WorkDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getWorkDefinitionAccess().getNameAssignment_1()); 
            // InternalPDL1.g:490:2: ( rule__WorkDefinition__NameAssignment_1 )
            // InternalPDL1.g:490:3: rule__WorkDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWorkDefinitionAccess().getNameAssignment_1()); 

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


    // $ANTLR start "rule__WorkDefinition__Group__2"
    // InternalPDL1.g:498:1: rule__WorkDefinition__Group__2 : rule__WorkDefinition__Group__2__Impl ;
    public final void rule__WorkDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:502:1: ( rule__WorkDefinition__Group__2__Impl )
            // InternalPDL1.g:503:2: rule__WorkDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group__2__Impl();

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
    // $ANTLR end "rule__WorkDefinition__Group__2"


    // $ANTLR start "rule__WorkDefinition__Group__2__Impl"
    // InternalPDL1.g:509:1: rule__WorkDefinition__Group__2__Impl : ( ( rule__WorkDefinition__OccurrencesAssignment_2 )* ) ;
    public final void rule__WorkDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:513:1: ( ( ( rule__WorkDefinition__OccurrencesAssignment_2 )* ) )
            // InternalPDL1.g:514:1: ( ( rule__WorkDefinition__OccurrencesAssignment_2 )* )
            {
            // InternalPDL1.g:514:1: ( ( rule__WorkDefinition__OccurrencesAssignment_2 )* )
            // InternalPDL1.g:515:2: ( rule__WorkDefinition__OccurrencesAssignment_2 )*
            {
             before(grammarAccess.getWorkDefinitionAccess().getOccurrencesAssignment_2()); 
            // InternalPDL1.g:516:2: ( rule__WorkDefinition__OccurrencesAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==24) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalPDL1.g:516:3: rule__WorkDefinition__OccurrencesAssignment_2
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__WorkDefinition__OccurrencesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getWorkDefinitionAccess().getOccurrencesAssignment_2()); 

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
    // $ANTLR end "rule__WorkDefinition__Group__2__Impl"


    // $ANTLR start "rule__WorkSequence__Group__0"
    // InternalPDL1.g:525:1: rule__WorkSequence__Group__0 : rule__WorkSequence__Group__0__Impl rule__WorkSequence__Group__1 ;
    public final void rule__WorkSequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:529:1: ( rule__WorkSequence__Group__0__Impl rule__WorkSequence__Group__1 )
            // InternalPDL1.g:530:2: rule__WorkSequence__Group__0__Impl rule__WorkSequence__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalPDL1.g:537:1: rule__WorkSequence__Group__0__Impl : ( 'ws' ) ;
    public final void rule__WorkSequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:541:1: ( ( 'ws' ) )
            // InternalPDL1.g:542:1: ( 'ws' )
            {
            // InternalPDL1.g:542:1: ( 'ws' )
            // InternalPDL1.g:543:2: 'ws'
            {
             before(grammarAccess.getWorkSequenceAccess().getWsKeyword_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getWsKeyword_0()); 

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
    // InternalPDL1.g:552:1: rule__WorkSequence__Group__1 : rule__WorkSequence__Group__1__Impl rule__WorkSequence__Group__2 ;
    public final void rule__WorkSequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:556:1: ( rule__WorkSequence__Group__1__Impl rule__WorkSequence__Group__2 )
            // InternalPDL1.g:557:2: rule__WorkSequence__Group__1__Impl rule__WorkSequence__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalPDL1.g:564:1: rule__WorkSequence__Group__1__Impl : ( ( rule__WorkSequence__LinkTypeAssignment_1 ) ) ;
    public final void rule__WorkSequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:568:1: ( ( ( rule__WorkSequence__LinkTypeAssignment_1 ) ) )
            // InternalPDL1.g:569:1: ( ( rule__WorkSequence__LinkTypeAssignment_1 ) )
            {
            // InternalPDL1.g:569:1: ( ( rule__WorkSequence__LinkTypeAssignment_1 ) )
            // InternalPDL1.g:570:2: ( rule__WorkSequence__LinkTypeAssignment_1 )
            {
             before(grammarAccess.getWorkSequenceAccess().getLinkTypeAssignment_1()); 
            // InternalPDL1.g:571:2: ( rule__WorkSequence__LinkTypeAssignment_1 )
            // InternalPDL1.g:571:3: rule__WorkSequence__LinkTypeAssignment_1
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
    // InternalPDL1.g:579:1: rule__WorkSequence__Group__2 : rule__WorkSequence__Group__2__Impl rule__WorkSequence__Group__3 ;
    public final void rule__WorkSequence__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:583:1: ( rule__WorkSequence__Group__2__Impl rule__WorkSequence__Group__3 )
            // InternalPDL1.g:584:2: rule__WorkSequence__Group__2__Impl rule__WorkSequence__Group__3
            {
            pushFollow(FOLLOW_3);
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
    // InternalPDL1.g:591:1: rule__WorkSequence__Group__2__Impl : ( 'from' ) ;
    public final void rule__WorkSequence__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:595:1: ( ( 'from' ) )
            // InternalPDL1.g:596:1: ( 'from' )
            {
            // InternalPDL1.g:596:1: ( 'from' )
            // InternalPDL1.g:597:2: 'from'
            {
             before(grammarAccess.getWorkSequenceAccess().getFromKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getFromKeyword_2()); 

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
    // InternalPDL1.g:606:1: rule__WorkSequence__Group__3 : rule__WorkSequence__Group__3__Impl rule__WorkSequence__Group__4 ;
    public final void rule__WorkSequence__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:610:1: ( rule__WorkSequence__Group__3__Impl rule__WorkSequence__Group__4 )
            // InternalPDL1.g:611:2: rule__WorkSequence__Group__3__Impl rule__WorkSequence__Group__4
            {
            pushFollow(FOLLOW_11);
            rule__WorkSequence__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__4();

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
    // InternalPDL1.g:618:1: rule__WorkSequence__Group__3__Impl : ( ( rule__WorkSequence__PredecessorAssignment_3 ) ) ;
    public final void rule__WorkSequence__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:622:1: ( ( ( rule__WorkSequence__PredecessorAssignment_3 ) ) )
            // InternalPDL1.g:623:1: ( ( rule__WorkSequence__PredecessorAssignment_3 ) )
            {
            // InternalPDL1.g:623:1: ( ( rule__WorkSequence__PredecessorAssignment_3 ) )
            // InternalPDL1.g:624:2: ( rule__WorkSequence__PredecessorAssignment_3 )
            {
             before(grammarAccess.getWorkSequenceAccess().getPredecessorAssignment_3()); 
            // InternalPDL1.g:625:2: ( rule__WorkSequence__PredecessorAssignment_3 )
            // InternalPDL1.g:625:3: rule__WorkSequence__PredecessorAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__PredecessorAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getPredecessorAssignment_3()); 

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


    // $ANTLR start "rule__WorkSequence__Group__4"
    // InternalPDL1.g:633:1: rule__WorkSequence__Group__4 : rule__WorkSequence__Group__4__Impl rule__WorkSequence__Group__5 ;
    public final void rule__WorkSequence__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:637:1: ( rule__WorkSequence__Group__4__Impl rule__WorkSequence__Group__5 )
            // InternalPDL1.g:638:2: rule__WorkSequence__Group__4__Impl rule__WorkSequence__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__WorkSequence__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__5();

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
    // $ANTLR end "rule__WorkSequence__Group__4"


    // $ANTLR start "rule__WorkSequence__Group__4__Impl"
    // InternalPDL1.g:645:1: rule__WorkSequence__Group__4__Impl : ( 'to' ) ;
    public final void rule__WorkSequence__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:649:1: ( ( 'to' ) )
            // InternalPDL1.g:650:1: ( 'to' )
            {
            // InternalPDL1.g:650:1: ( 'to' )
            // InternalPDL1.g:651:2: 'to'
            {
             before(grammarAccess.getWorkSequenceAccess().getToKeyword_4()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getToKeyword_4()); 

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
    // $ANTLR end "rule__WorkSequence__Group__4__Impl"


    // $ANTLR start "rule__WorkSequence__Group__5"
    // InternalPDL1.g:660:1: rule__WorkSequence__Group__5 : rule__WorkSequence__Group__5__Impl ;
    public final void rule__WorkSequence__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:664:1: ( rule__WorkSequence__Group__5__Impl )
            // InternalPDL1.g:665:2: rule__WorkSequence__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__5__Impl();

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
    // $ANTLR end "rule__WorkSequence__Group__5"


    // $ANTLR start "rule__WorkSequence__Group__5__Impl"
    // InternalPDL1.g:671:1: rule__WorkSequence__Group__5__Impl : ( ( rule__WorkSequence__SuccessorAssignment_5 ) ) ;
    public final void rule__WorkSequence__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:675:1: ( ( ( rule__WorkSequence__SuccessorAssignment_5 ) ) )
            // InternalPDL1.g:676:1: ( ( rule__WorkSequence__SuccessorAssignment_5 ) )
            {
            // InternalPDL1.g:676:1: ( ( rule__WorkSequence__SuccessorAssignment_5 ) )
            // InternalPDL1.g:677:2: ( rule__WorkSequence__SuccessorAssignment_5 )
            {
             before(grammarAccess.getWorkSequenceAccess().getSuccessorAssignment_5()); 
            // InternalPDL1.g:678:2: ( rule__WorkSequence__SuccessorAssignment_5 )
            // InternalPDL1.g:678:3: rule__WorkSequence__SuccessorAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__SuccessorAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getSuccessorAssignment_5()); 

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
    // $ANTLR end "rule__WorkSequence__Group__5__Impl"


    // $ANTLR start "rule__Guidance__Group__0"
    // InternalPDL1.g:687:1: rule__Guidance__Group__0 : rule__Guidance__Group__0__Impl rule__Guidance__Group__1 ;
    public final void rule__Guidance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:691:1: ( rule__Guidance__Group__0__Impl rule__Guidance__Group__1 )
            // InternalPDL1.g:692:2: rule__Guidance__Group__0__Impl rule__Guidance__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Guidance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Guidance__Group__1();

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
    // $ANTLR end "rule__Guidance__Group__0"


    // $ANTLR start "rule__Guidance__Group__0__Impl"
    // InternalPDL1.g:699:1: rule__Guidance__Group__0__Impl : ( 'note' ) ;
    public final void rule__Guidance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:703:1: ( ( 'note' ) )
            // InternalPDL1.g:704:1: ( 'note' )
            {
            // InternalPDL1.g:704:1: ( 'note' )
            // InternalPDL1.g:705:2: 'note'
            {
             before(grammarAccess.getGuidanceAccess().getNoteKeyword_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getGuidanceAccess().getNoteKeyword_0()); 

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
    // $ANTLR end "rule__Guidance__Group__0__Impl"


    // $ANTLR start "rule__Guidance__Group__1"
    // InternalPDL1.g:714:1: rule__Guidance__Group__1 : rule__Guidance__Group__1__Impl ;
    public final void rule__Guidance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:718:1: ( rule__Guidance__Group__1__Impl )
            // InternalPDL1.g:719:2: rule__Guidance__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Guidance__Group__1__Impl();

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
    // $ANTLR end "rule__Guidance__Group__1"


    // $ANTLR start "rule__Guidance__Group__1__Impl"
    // InternalPDL1.g:725:1: rule__Guidance__Group__1__Impl : ( ( rule__Guidance__TexteAssignment_1 ) ) ;
    public final void rule__Guidance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:729:1: ( ( ( rule__Guidance__TexteAssignment_1 ) ) )
            // InternalPDL1.g:730:1: ( ( rule__Guidance__TexteAssignment_1 ) )
            {
            // InternalPDL1.g:730:1: ( ( rule__Guidance__TexteAssignment_1 ) )
            // InternalPDL1.g:731:2: ( rule__Guidance__TexteAssignment_1 )
            {
             before(grammarAccess.getGuidanceAccess().getTexteAssignment_1()); 
            // InternalPDL1.g:732:2: ( rule__Guidance__TexteAssignment_1 )
            // InternalPDL1.g:732:3: rule__Guidance__TexteAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Guidance__TexteAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGuidanceAccess().getTexteAssignment_1()); 

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
    // $ANTLR end "rule__Guidance__Group__1__Impl"


    // $ANTLR start "rule__Ressource__Group__0"
    // InternalPDL1.g:741:1: rule__Ressource__Group__0 : rule__Ressource__Group__0__Impl rule__Ressource__Group__1 ;
    public final void rule__Ressource__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:745:1: ( rule__Ressource__Group__0__Impl rule__Ressource__Group__1 )
            // InternalPDL1.g:746:2: rule__Ressource__Group__0__Impl rule__Ressource__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Ressource__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ressource__Group__1();

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
    // $ANTLR end "rule__Ressource__Group__0"


    // $ANTLR start "rule__Ressource__Group__0__Impl"
    // InternalPDL1.g:753:1: rule__Ressource__Group__0__Impl : ( 'ress' ) ;
    public final void rule__Ressource__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:757:1: ( ( 'ress' ) )
            // InternalPDL1.g:758:1: ( 'ress' )
            {
            // InternalPDL1.g:758:1: ( 'ress' )
            // InternalPDL1.g:759:2: 'ress'
            {
             before(grammarAccess.getRessourceAccess().getRessKeyword_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getRessourceAccess().getRessKeyword_0()); 

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
    // $ANTLR end "rule__Ressource__Group__0__Impl"


    // $ANTLR start "rule__Ressource__Group__1"
    // InternalPDL1.g:768:1: rule__Ressource__Group__1 : rule__Ressource__Group__1__Impl rule__Ressource__Group__2 ;
    public final void rule__Ressource__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:772:1: ( rule__Ressource__Group__1__Impl rule__Ressource__Group__2 )
            // InternalPDL1.g:773:2: rule__Ressource__Group__1__Impl rule__Ressource__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__Ressource__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ressource__Group__2();

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
    // $ANTLR end "rule__Ressource__Group__1"


    // $ANTLR start "rule__Ressource__Group__1__Impl"
    // InternalPDL1.g:780:1: rule__Ressource__Group__1__Impl : ( ( rule__Ressource__NameAssignment_1 ) ) ;
    public final void rule__Ressource__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:784:1: ( ( ( rule__Ressource__NameAssignment_1 ) ) )
            // InternalPDL1.g:785:1: ( ( rule__Ressource__NameAssignment_1 ) )
            {
            // InternalPDL1.g:785:1: ( ( rule__Ressource__NameAssignment_1 ) )
            // InternalPDL1.g:786:2: ( rule__Ressource__NameAssignment_1 )
            {
             before(grammarAccess.getRessourceAccess().getNameAssignment_1()); 
            // InternalPDL1.g:787:2: ( rule__Ressource__NameAssignment_1 )
            // InternalPDL1.g:787:3: rule__Ressource__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Ressource__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRessourceAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Ressource__Group__1__Impl"


    // $ANTLR start "rule__Ressource__Group__2"
    // InternalPDL1.g:795:1: rule__Ressource__Group__2 : rule__Ressource__Group__2__Impl ;
    public final void rule__Ressource__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:799:1: ( rule__Ressource__Group__2__Impl )
            // InternalPDL1.g:800:2: rule__Ressource__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Ressource__Group__2__Impl();

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
    // $ANTLR end "rule__Ressource__Group__2"


    // $ANTLR start "rule__Ressource__Group__2__Impl"
    // InternalPDL1.g:806:1: rule__Ressource__Group__2__Impl : ( ( rule__Ressource__QuantiteAssignment_2 ) ) ;
    public final void rule__Ressource__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:810:1: ( ( ( rule__Ressource__QuantiteAssignment_2 ) ) )
            // InternalPDL1.g:811:1: ( ( rule__Ressource__QuantiteAssignment_2 ) )
            {
            // InternalPDL1.g:811:1: ( ( rule__Ressource__QuantiteAssignment_2 ) )
            // InternalPDL1.g:812:2: ( rule__Ressource__QuantiteAssignment_2 )
            {
             before(grammarAccess.getRessourceAccess().getQuantiteAssignment_2()); 
            // InternalPDL1.g:813:2: ( rule__Ressource__QuantiteAssignment_2 )
            // InternalPDL1.g:813:3: rule__Ressource__QuantiteAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Ressource__QuantiteAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRessourceAccess().getQuantiteAssignment_2()); 

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
    // $ANTLR end "rule__Ressource__Group__2__Impl"


    // $ANTLR start "rule__Occurrence__Group__0"
    // InternalPDL1.g:822:1: rule__Occurrence__Group__0 : rule__Occurrence__Group__0__Impl rule__Occurrence__Group__1 ;
    public final void rule__Occurrence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:826:1: ( rule__Occurrence__Group__0__Impl rule__Occurrence__Group__1 )
            // InternalPDL1.g:827:2: rule__Occurrence__Group__0__Impl rule__Occurrence__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__Occurrence__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Occurrence__Group__1();

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
    // $ANTLR end "rule__Occurrence__Group__0"


    // $ANTLR start "rule__Occurrence__Group__0__Impl"
    // InternalPDL1.g:834:1: rule__Occurrence__Group__0__Impl : ( 'occ' ) ;
    public final void rule__Occurrence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:838:1: ( ( 'occ' ) )
            // InternalPDL1.g:839:1: ( 'occ' )
            {
            // InternalPDL1.g:839:1: ( 'occ' )
            // InternalPDL1.g:840:2: 'occ'
            {
             before(grammarAccess.getOccurrenceAccess().getOccKeyword_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getOccurrenceAccess().getOccKeyword_0()); 

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
    // $ANTLR end "rule__Occurrence__Group__0__Impl"


    // $ANTLR start "rule__Occurrence__Group__1"
    // InternalPDL1.g:849:1: rule__Occurrence__Group__1 : rule__Occurrence__Group__1__Impl rule__Occurrence__Group__2 ;
    public final void rule__Occurrence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:853:1: ( rule__Occurrence__Group__1__Impl rule__Occurrence__Group__2 )
            // InternalPDL1.g:854:2: rule__Occurrence__Group__1__Impl rule__Occurrence__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Occurrence__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Occurrence__Group__2();

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
    // $ANTLR end "rule__Occurrence__Group__1"


    // $ANTLR start "rule__Occurrence__Group__1__Impl"
    // InternalPDL1.g:861:1: rule__Occurrence__Group__1__Impl : ( ( rule__Occurrence__OccurrenceAssignment_1 ) ) ;
    public final void rule__Occurrence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:865:1: ( ( ( rule__Occurrence__OccurrenceAssignment_1 ) ) )
            // InternalPDL1.g:866:1: ( ( rule__Occurrence__OccurrenceAssignment_1 ) )
            {
            // InternalPDL1.g:866:1: ( ( rule__Occurrence__OccurrenceAssignment_1 ) )
            // InternalPDL1.g:867:2: ( rule__Occurrence__OccurrenceAssignment_1 )
            {
             before(grammarAccess.getOccurrenceAccess().getOccurrenceAssignment_1()); 
            // InternalPDL1.g:868:2: ( rule__Occurrence__OccurrenceAssignment_1 )
            // InternalPDL1.g:868:3: rule__Occurrence__OccurrenceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Occurrence__OccurrenceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOccurrenceAccess().getOccurrenceAssignment_1()); 

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
    // $ANTLR end "rule__Occurrence__Group__1__Impl"


    // $ANTLR start "rule__Occurrence__Group__2"
    // InternalPDL1.g:876:1: rule__Occurrence__Group__2 : rule__Occurrence__Group__2__Impl rule__Occurrence__Group__3 ;
    public final void rule__Occurrence__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:880:1: ( rule__Occurrence__Group__2__Impl rule__Occurrence__Group__3 )
            // InternalPDL1.g:881:2: rule__Occurrence__Group__2__Impl rule__Occurrence__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__Occurrence__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Occurrence__Group__3();

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
    // $ANTLR end "rule__Occurrence__Group__2"


    // $ANTLR start "rule__Occurrence__Group__2__Impl"
    // InternalPDL1.g:888:1: rule__Occurrence__Group__2__Impl : ( ( rule__Occurrence__RessourceUtileAssignment_2 ) ) ;
    public final void rule__Occurrence__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:892:1: ( ( ( rule__Occurrence__RessourceUtileAssignment_2 ) ) )
            // InternalPDL1.g:893:1: ( ( rule__Occurrence__RessourceUtileAssignment_2 ) )
            {
            // InternalPDL1.g:893:1: ( ( rule__Occurrence__RessourceUtileAssignment_2 ) )
            // InternalPDL1.g:894:2: ( rule__Occurrence__RessourceUtileAssignment_2 )
            {
             before(grammarAccess.getOccurrenceAccess().getRessourceUtileAssignment_2()); 
            // InternalPDL1.g:895:2: ( rule__Occurrence__RessourceUtileAssignment_2 )
            // InternalPDL1.g:895:3: rule__Occurrence__RessourceUtileAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Occurrence__RessourceUtileAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOccurrenceAccess().getRessourceUtileAssignment_2()); 

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
    // $ANTLR end "rule__Occurrence__Group__2__Impl"


    // $ANTLR start "rule__Occurrence__Group__3"
    // InternalPDL1.g:903:1: rule__Occurrence__Group__3 : rule__Occurrence__Group__3__Impl ;
    public final void rule__Occurrence__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:907:1: ( rule__Occurrence__Group__3__Impl )
            // InternalPDL1.g:908:2: rule__Occurrence__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Occurrence__Group__3__Impl();

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
    // $ANTLR end "rule__Occurrence__Group__3"


    // $ANTLR start "rule__Occurrence__Group__3__Impl"
    // InternalPDL1.g:914:1: rule__Occurrence__Group__3__Impl : ( ( rule__Occurrence__WdAssocieeAssignment_3 ) ) ;
    public final void rule__Occurrence__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:918:1: ( ( ( rule__Occurrence__WdAssocieeAssignment_3 ) ) )
            // InternalPDL1.g:919:1: ( ( rule__Occurrence__WdAssocieeAssignment_3 ) )
            {
            // InternalPDL1.g:919:1: ( ( rule__Occurrence__WdAssocieeAssignment_3 ) )
            // InternalPDL1.g:920:2: ( rule__Occurrence__WdAssocieeAssignment_3 )
            {
             before(grammarAccess.getOccurrenceAccess().getWdAssocieeAssignment_3()); 
            // InternalPDL1.g:921:2: ( rule__Occurrence__WdAssocieeAssignment_3 )
            // InternalPDL1.g:921:3: rule__Occurrence__WdAssocieeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Occurrence__WdAssocieeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getOccurrenceAccess().getWdAssocieeAssignment_3()); 

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
    // $ANTLR end "rule__Occurrence__Group__3__Impl"


    // $ANTLR start "rule__Process__NameAssignment_1"
    // InternalPDL1.g:930:1: rule__Process__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Process__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:934:1: ( ( RULE_ID ) )
            // InternalPDL1.g:935:2: ( RULE_ID )
            {
            // InternalPDL1.g:935:2: ( RULE_ID )
            // InternalPDL1.g:936:3: RULE_ID
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


    // $ANTLR start "rule__Process__ProcessElementsAssignment_3"
    // InternalPDL1.g:945:1: rule__Process__ProcessElementsAssignment_3 : ( ruleProcessElement ) ;
    public final void rule__Process__ProcessElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:949:1: ( ( ruleProcessElement ) )
            // InternalPDL1.g:950:2: ( ruleProcessElement )
            {
            // InternalPDL1.g:950:2: ( ruleProcessElement )
            // InternalPDL1.g:951:3: ruleProcessElement
            {
             before(grammarAccess.getProcessAccess().getProcessElementsProcessElementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleProcessElement();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getProcessElementsProcessElementParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Process__ProcessElementsAssignment_3"


    // $ANTLR start "rule__WorkDefinition__NameAssignment_1"
    // InternalPDL1.g:960:1: rule__WorkDefinition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__WorkDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:964:1: ( ( RULE_ID ) )
            // InternalPDL1.g:965:2: ( RULE_ID )
            {
            // InternalPDL1.g:965:2: ( RULE_ID )
            // InternalPDL1.g:966:3: RULE_ID
            {
             before(grammarAccess.getWorkDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWorkDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__WorkDefinition__NameAssignment_1"


    // $ANTLR start "rule__WorkDefinition__OccurrencesAssignment_2"
    // InternalPDL1.g:975:1: rule__WorkDefinition__OccurrencesAssignment_2 : ( ruleOccurrence ) ;
    public final void rule__WorkDefinition__OccurrencesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:979:1: ( ( ruleOccurrence ) )
            // InternalPDL1.g:980:2: ( ruleOccurrence )
            {
            // InternalPDL1.g:980:2: ( ruleOccurrence )
            // InternalPDL1.g:981:3: ruleOccurrence
            {
             before(grammarAccess.getWorkDefinitionAccess().getOccurrencesOccurrenceParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOccurrence();

            state._fsp--;

             after(grammarAccess.getWorkDefinitionAccess().getOccurrencesOccurrenceParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__WorkDefinition__OccurrencesAssignment_2"


    // $ANTLR start "rule__WorkSequence__LinkTypeAssignment_1"
    // InternalPDL1.g:990:1: rule__WorkSequence__LinkTypeAssignment_1 : ( ruleWorkSequenceType ) ;
    public final void rule__WorkSequence__LinkTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:994:1: ( ( ruleWorkSequenceType ) )
            // InternalPDL1.g:995:2: ( ruleWorkSequenceType )
            {
            // InternalPDL1.g:995:2: ( ruleWorkSequenceType )
            // InternalPDL1.g:996:3: ruleWorkSequenceType
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


    // $ANTLR start "rule__WorkSequence__PredecessorAssignment_3"
    // InternalPDL1.g:1005:1: rule__WorkSequence__PredecessorAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__WorkSequence__PredecessorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1009:1: ( ( ( RULE_ID ) ) )
            // InternalPDL1.g:1010:2: ( ( RULE_ID ) )
            {
            // InternalPDL1.g:1010:2: ( ( RULE_ID ) )
            // InternalPDL1.g:1011:3: ( RULE_ID )
            {
             before(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionCrossReference_3_0()); 
            // InternalPDL1.g:1012:3: ( RULE_ID )
            // InternalPDL1.g:1013:4: RULE_ID
            {
             before(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionCrossReference_3_0()); 

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
    // $ANTLR end "rule__WorkSequence__PredecessorAssignment_3"


    // $ANTLR start "rule__WorkSequence__SuccessorAssignment_5"
    // InternalPDL1.g:1024:1: rule__WorkSequence__SuccessorAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__WorkSequence__SuccessorAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1028:1: ( ( ( RULE_ID ) ) )
            // InternalPDL1.g:1029:2: ( ( RULE_ID ) )
            {
            // InternalPDL1.g:1029:2: ( ( RULE_ID ) )
            // InternalPDL1.g:1030:3: ( RULE_ID )
            {
             before(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionCrossReference_5_0()); 
            // InternalPDL1.g:1031:3: ( RULE_ID )
            // InternalPDL1.g:1032:4: RULE_ID
            {
             before(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionCrossReference_5_0()); 

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
    // $ANTLR end "rule__WorkSequence__SuccessorAssignment_5"


    // $ANTLR start "rule__Guidance__TexteAssignment_1"
    // InternalPDL1.g:1043:1: rule__Guidance__TexteAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Guidance__TexteAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1047:1: ( ( RULE_STRING ) )
            // InternalPDL1.g:1048:2: ( RULE_STRING )
            {
            // InternalPDL1.g:1048:2: ( RULE_STRING )
            // InternalPDL1.g:1049:3: RULE_STRING
            {
             before(grammarAccess.getGuidanceAccess().getTexteSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getGuidanceAccess().getTexteSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Guidance__TexteAssignment_1"


    // $ANTLR start "rule__Ressource__NameAssignment_1"
    // InternalPDL1.g:1058:1: rule__Ressource__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Ressource__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1062:1: ( ( RULE_ID ) )
            // InternalPDL1.g:1063:2: ( RULE_ID )
            {
            // InternalPDL1.g:1063:2: ( RULE_ID )
            // InternalPDL1.g:1064:3: RULE_ID
            {
             before(grammarAccess.getRessourceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getRessourceAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Ressource__NameAssignment_1"


    // $ANTLR start "rule__Ressource__QuantiteAssignment_2"
    // InternalPDL1.g:1073:1: rule__Ressource__QuantiteAssignment_2 : ( RULE_INT ) ;
    public final void rule__Ressource__QuantiteAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1077:1: ( ( RULE_INT ) )
            // InternalPDL1.g:1078:2: ( RULE_INT )
            {
            // InternalPDL1.g:1078:2: ( RULE_INT )
            // InternalPDL1.g:1079:3: RULE_INT
            {
             before(grammarAccess.getRessourceAccess().getQuantiteINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getRessourceAccess().getQuantiteINTTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Ressource__QuantiteAssignment_2"


    // $ANTLR start "rule__Occurrence__OccurrenceAssignment_1"
    // InternalPDL1.g:1088:1: rule__Occurrence__OccurrenceAssignment_1 : ( RULE_INT ) ;
    public final void rule__Occurrence__OccurrenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1092:1: ( ( RULE_INT ) )
            // InternalPDL1.g:1093:2: ( RULE_INT )
            {
            // InternalPDL1.g:1093:2: ( RULE_INT )
            // InternalPDL1.g:1094:3: RULE_INT
            {
             before(grammarAccess.getOccurrenceAccess().getOccurrenceINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getOccurrenceAccess().getOccurrenceINTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Occurrence__OccurrenceAssignment_1"


    // $ANTLR start "rule__Occurrence__RessourceUtileAssignment_2"
    // InternalPDL1.g:1103:1: rule__Occurrence__RessourceUtileAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Occurrence__RessourceUtileAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1107:1: ( ( ( RULE_ID ) ) )
            // InternalPDL1.g:1108:2: ( ( RULE_ID ) )
            {
            // InternalPDL1.g:1108:2: ( ( RULE_ID ) )
            // InternalPDL1.g:1109:3: ( RULE_ID )
            {
             before(grammarAccess.getOccurrenceAccess().getRessourceUtileRessourceCrossReference_2_0()); 
            // InternalPDL1.g:1110:3: ( RULE_ID )
            // InternalPDL1.g:1111:4: RULE_ID
            {
             before(grammarAccess.getOccurrenceAccess().getRessourceUtileRessourceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOccurrenceAccess().getRessourceUtileRessourceIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getOccurrenceAccess().getRessourceUtileRessourceCrossReference_2_0()); 

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
    // $ANTLR end "rule__Occurrence__RessourceUtileAssignment_2"


    // $ANTLR start "rule__Occurrence__WdAssocieeAssignment_3"
    // InternalPDL1.g:1122:1: rule__Occurrence__WdAssocieeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Occurrence__WdAssocieeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1126:1: ( ( ( RULE_ID ) ) )
            // InternalPDL1.g:1127:2: ( ( RULE_ID ) )
            {
            // InternalPDL1.g:1127:2: ( ( RULE_ID ) )
            // InternalPDL1.g:1128:3: ( RULE_ID )
            {
             before(grammarAccess.getOccurrenceAccess().getWdAssocieeWorkDefinitionCrossReference_3_0()); 
            // InternalPDL1.g:1129:3: ( RULE_ID )
            // InternalPDL1.g:1130:4: RULE_ID
            {
             before(grammarAccess.getOccurrenceAccess().getWdAssocieeWorkDefinitionIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOccurrenceAccess().getWdAssocieeWorkDefinitionIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getOccurrenceAccess().getWdAssocieeWorkDefinitionCrossReference_3_0()); 

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
    // $ANTLR end "rule__Occurrence__WdAssocieeAssignment_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000CE0000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000CC0002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000040L});

}