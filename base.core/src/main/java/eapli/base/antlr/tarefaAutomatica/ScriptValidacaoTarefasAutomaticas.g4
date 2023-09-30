grammar ScriptValidacaoTarefasAutomaticas;
start: 'START' '{' script '}' 'END';

script: chamar_funcao+;

operacao_matematica:
    inteiro OPERADOR_COMPARAR inteiro |inteiro;

chamar_funcao: sendEmail | changeNIF | changeTelephoneNumber | xml | verificacaoIf;

xml: 'consultar' cod_produto=INTEIRO ';'#consultar
    | 'calcValorTotal'  cod_produto=INTEIRO quantidade=INTEIRO';'#calcValorTotal
    | 'AlterarPercentagemBaseDesconto'  cod_produto=INTEIRO verificacaoIf+ ';'#percentagemBaseDesconto
    | 'atualizar' ':' parametro=PALAVRA valor=INTEIRO categoria=PALAVRA  ';'#atualizarCategoria
    | 'calcValorDesconto' cod_produto=INTEIRO quantidade=INTEIRO';'#calcValorDesconto
    ;

sendEmail: 'SendEmail' '(' subject=PALAVRA ',' content ')' ';' #enviarEmail
    ;

content: INTEIRO
        |PALAVRA
        |content INTEIRO 
        |content PALAVRA
;

verificacaoIf: 'if' ':' condicao 'then' ':' conteudoif ';' ;

condicao:  PALAVRA OPERADOR_COMPARAR INTEIRO
         |  compararConteudoPalavra
         ;

compararConteudoPalavra: INTEIRO OPERADOR_COMPARAR '"'PALAVRA'"'
;

conteudoif: conteudoif config
        |config
        ;

config:  'desconto e' INTEIRO '%'
       | sendEmail ;

changeNIF: 'changeNIF' '(' campoDoNIFNoFormulario=INTEIRO ')' ';';

changeTelephoneNumber: 'changeTelephoneNumber' '(' campoDoTeleNoFormulario=INTEIRO ')' ';';

inteiro:
    '(' inteiro ')'    # realizarCalculoPrioritario
    | left=inteiro op=('*'|'/') right=inteiro # opExprMulDiv
    | left=inteiro op=('+'|'-') right=inteiro # opExprSumDif
    | atom=INTEIRO #atomExpr
    ;

//VARIAVEIS
OPERADOR_MATEMATICO: '+'|'-'|'*'|'/';
OPERADOR_COMPARAR:'=='|'<>'|'<'|'>'|'<='|'>='|'!=';
PALAVRA: STRING (WS STRING)*;
fragment STRING: [A-Za-z]+;
INTEIRO: [0-9]+;
WS : [ \t\r\n]+ -> skip ;


