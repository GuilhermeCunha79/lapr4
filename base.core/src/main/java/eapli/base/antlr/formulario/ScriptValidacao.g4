grammar ScriptValidacao;
prog: 
    |prog verificacaoIf
    |prog config
    ;

verificacaoIf: 'if' condicoes 'then' conteudo ';' ;

conteudo: conteudo conteudocondicoes
        |conteudo config
        |conteudo verificacaoIf
        |conteudocondicoes
        |config
        |verificacaoIf
        ;

config: '$'Inteiro 'tamanho e' Inteiro ';' #valueTamanho
        | '$'Inteiro 'esta entre' intervalo ';'  #valueEstaEntre
        | '$'Inteiro 'e' Obrigatoriedade ';' #valueEObrigadorio
        | compararValores #valueVerificarIgualOuDiferente
        | decimal (OperadorLogico|IgualOuDiferente) Inteiro #decimalVerificarIgualOuDiferente
        ;

conteudocondicoes: condicoes ';'
                 ;

condicoes: condicao   #condicoesSemOperador
            | condicoes OperadorCondicao condicao #condicoesOperador
            ;

condicao:
            '$'Inteiro ':' EstadoString #valueEstado
            |'$'Inteiro IgualOuDiferente condicaoString #valueStringIgual
            |'$'Inteiro IgualOuDiferente ValorBool #valueBoolean
            |ValorBool IgualOuDiferente '$'Inteiro #booleanValue
            |compararValores #valueVerificarIgualOuDiferente2
            ;

compararValores:  '$'Inteiro (OperadorLogico|IgualOuDiferente) expressaoIntDados
                 |'$'Inteiro (OperadorLogico|IgualOuDiferente) expressaoIntLiteral
                 ;

condicaoString: stringEntreAspas | valorString;

stringEntreAspas: '"' valorString '"';

valorString: String 
            | String valorString
        ;


expressaoIntLiteral: Inteiro
                | expressaoIntLiteral OperadorMatematico Inteiro
                ;

expressaoIntDados: '$'Inteiro
                | expressaoIntDados OperadorMatematico '$'Inteiro
                ;



decimal: '$'Inteiro '.decimal';

intervalo: Inteiro 'e' Inteiro;


EstadoString: 'cheio' | 'vazio' ;
OperadorLogico: '<'|'>'|'<='|'>=';
ValorBool: 'verdadeiro'|'falso';
IgualOuDiferente: '=='|'!=';
OperadorCondicao: '&&' | '||';
TipoOpcao: 'Inteiro'|'Real'|'String';
OperadorMatematico: '+'|'-'|'*'|'/';
Obrigatoriedade: 'obrigatorio' | 'nao obrigatorio';
String: [A-Za-z]+;
Inteiro: [0-9]+;
WS : [ \t\r\n]+ -> skip ;


