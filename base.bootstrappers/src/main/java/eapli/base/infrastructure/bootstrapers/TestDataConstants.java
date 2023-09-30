package eapli.base.infrastructure.bootstrapers;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoServicosHD.domain.CodigoServico;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.EtiquetaAtributoFormulario;
import eapli.base.gestaoServicosHD.domain.ExpressaoRegular;
import eapli.base.gestaoServicosHD.domain.IdentificadorCatalogo;
import eapli.base.gestaoServicosHD.domain.IdentificadorFormulario;
import eapli.base.gestaoServicosHD.domain.IdentificadorPedido;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoDepartamento;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoEquipa;
import eapli.base.gestaoServicosRH.domain.EmailInstitucional;

public final class TestDataConstants {

    public static final CodigoUnicoDepartamento DEPARTAMENTO_A = new CodigoUnicoDepartamento("A1");
    public static final CodigoUnicoDepartamento DEPARTAMENTO_B = new CodigoUnicoDepartamento("B2");

    public static final EmailInstitucional COLABORADOR_A1 = new EmailInstitucional("goncalo172@live.com.pt");
    public static final EmailInstitucional COLABORADOR_A2 = new EmailInstitucional("ola2@hotmail.com");
    public static final EmailInstitucional COLABORADOR_A3 = new EmailInstitucional("ola3@hotmail.com");

    public static final CodigoUnicoEquipa EQUIPA_A = new CodigoUnicoEquipa("A1");
    public static final CodigoUnicoEquipa EQUIPA_B = new CodigoUnicoEquipa("B1");

    public static final IdentificadorCatalogo CATALOGO_1 = new IdentificadorCatalogo("111");
    public static final IdentificadorCatalogo CATALOGO_2 = new IdentificadorCatalogo("222");

    public static final CodigoServico SERVICO_1 = new CodigoServico("S1");
    public static final CodigoServico SERVICO_2 = new CodigoServico("S2");
    public static final CodigoServico SERVICO_3 = new CodigoServico("S3");
    public static final CodigoServico SERVICO_4 = new CodigoServico("S4");

    public static final IdentificadorFormulario FORMULARIO_11 = new IdentificadorFormulario("11");
    public static final IdentificadorFormulario FORMULARIO_12 = new IdentificadorFormulario("12");
    public static final IdentificadorFormulario FORMULARIO_13 = new IdentificadorFormulario("13");
    public static final IdentificadorFormulario FORMULARIO_21 = new IdentificadorFormulario("21");
    public static final IdentificadorFormulario FORMULARIO_22 = new IdentificadorFormulario("22");
    public static final IdentificadorFormulario FORMULARIO_31 = new IdentificadorFormulario("31");
    public static final IdentificadorFormulario FORMULARIO_32 = new IdentificadorFormulario("32");
    public static final IdentificadorFormulario FORMULARIO_41 = new IdentificadorFormulario("41");

    //S1 Solicitacao
    public static final EtiquetaAtributoFormulario ATRIBUTO_111 = new EtiquetaAtributoFormulario("atributo111");
    public static final EtiquetaAtributoFormulario ATRIBUTO_112 = new EtiquetaAtributoFormulario("atributo112");
    public static final EtiquetaAtributoFormulario ATRIBUTO_113 = new EtiquetaAtributoFormulario("atributo113");
    public static final EtiquetaAtributoFormulario ATRIBUTO_114 = new EtiquetaAtributoFormulario("atributo114");
    //S1 Aprovacao
    public static final EtiquetaAtributoFormulario ATRIBUTO_121 = new EtiquetaAtributoFormulario("atributo121");
    public static final EtiquetaAtributoFormulario ATRIBUTO_122 = new EtiquetaAtributoFormulario("atributo122");
    //S1 Realizacao
    public static final EtiquetaAtributoFormulario ATRIBUTO_131 = new EtiquetaAtributoFormulario("atributo131");
    public static final EtiquetaAtributoFormulario ATRIBUTO_132 = new EtiquetaAtributoFormulario("atributo132");
    public static final EtiquetaAtributoFormulario ATRIBUTO_133 = new EtiquetaAtributoFormulario("atributo133");
    public static final EtiquetaAtributoFormulario ATRIBUTO_134 = new EtiquetaAtributoFormulario("atributo134");
    public static final EtiquetaAtributoFormulario ATRIBUTO_135 = new EtiquetaAtributoFormulario("atributo135");
    public static final EtiquetaAtributoFormulario ATRIBUTO_136 = new EtiquetaAtributoFormulario("atributo136");
    public static final EtiquetaAtributoFormulario ATRIBUTO_137 = new EtiquetaAtributoFormulario("atributo137");
    public static final EtiquetaAtributoFormulario ATRIBUTO_138 = new EtiquetaAtributoFormulario("atributo138");
    public static final EtiquetaAtributoFormulario ATRIBUTO_139 = new EtiquetaAtributoFormulario("atributo139");
    public static final EtiquetaAtributoFormulario ATRIBUTO_1310 = new EtiquetaAtributoFormulario("atributo1310");
    
    //S2 Solicitacao
    public static final EtiquetaAtributoFormulario ATRIBUTO_211 = new EtiquetaAtributoFormulario("atributo211");
    public static final EtiquetaAtributoFormulario ATRIBUTO_212 = new EtiquetaAtributoFormulario("atributo212");
    public static final EtiquetaAtributoFormulario ATRIBUTO_213 = new EtiquetaAtributoFormulario("atributo213");
    public static final EtiquetaAtributoFormulario ATRIBUTO_214 = new EtiquetaAtributoFormulario("atributo214");
    public static final EtiquetaAtributoFormulario ATRIBUTO_215 = new EtiquetaAtributoFormulario("atributo215");
    public static final EtiquetaAtributoFormulario ATRIBUTO_216 = new EtiquetaAtributoFormulario("atributo216");
    public static final EtiquetaAtributoFormulario ATRIBUTO_217 = new EtiquetaAtributoFormulario("atributo217");
    public static final EtiquetaAtributoFormulario ATRIBUTO_218 = new EtiquetaAtributoFormulario("atributo218");
    public static final EtiquetaAtributoFormulario ATRIBUTO_219 = new EtiquetaAtributoFormulario("atributo219");
    //S2 Aprovacao
    public static final EtiquetaAtributoFormulario ATRIBUTO_221 = new EtiquetaAtributoFormulario("atributo221");
    public static final EtiquetaAtributoFormulario ATRIBUTO_222 = new EtiquetaAtributoFormulario("atributo222");
    public static final EtiquetaAtributoFormulario ATRIBUTO_223 = new EtiquetaAtributoFormulario("atributo223");
    public static final EtiquetaAtributoFormulario ATRIBUTO_224 = new EtiquetaAtributoFormulario("atributo224");
    public static final EtiquetaAtributoFormulario ATRIBUTO_225 = new EtiquetaAtributoFormulario("atributo225");
    
    //S3 Solicitacao
    public static final EtiquetaAtributoFormulario ATRIBUTO_311 = new EtiquetaAtributoFormulario("atributo311");
    public static final EtiquetaAtributoFormulario ATRIBUTO_312 = new EtiquetaAtributoFormulario("atributo312");
    public static final EtiquetaAtributoFormulario ATRIBUTO_313 = new EtiquetaAtributoFormulario("atributo313");
    public static final EtiquetaAtributoFormulario ATRIBUTO_314 = new EtiquetaAtributoFormulario("atributo314");
    //S3 Realizacao
    public static final EtiquetaAtributoFormulario ATRIBUTO_321 = new EtiquetaAtributoFormulario("atributo321");
    
    //S4 Solicitacao
    public static final EtiquetaAtributoFormulario ATRIBUTO_411 = new EtiquetaAtributoFormulario("atributo411");
    public static final EtiquetaAtributoFormulario ATRIBUTO_412 = new EtiquetaAtributoFormulario("atributo412");
    public static final EtiquetaAtributoFormulario ATRIBUTO_413 = new EtiquetaAtributoFormulario("atributo413");
    
    public static final ExpressaoRegular DATA_REGEX = new ExpressaoRegular("^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$|");
    public static final ExpressaoRegular INTEIRO_REGEX = new ExpressaoRegular("[0-9]*");
    public static final ExpressaoRegular DOUBLE_REGEX = new ExpressaoRegular("[0-9]*.[0-9]*");
    public static final ExpressaoRegular STRING_REGEX = new ExpressaoRegular("[a-zA-Z0-9,.?! ]*");
    public static final ExpressaoRegular CODIGO_POSTAL_REGEX = new ExpressaoRegular("[0-9]{4}-[0-9]{3}|");
    
    public static final DescricaoBreve ATIVIDADE_11 = new DescricaoBreve("atividadeAprovacaoS1");
    public static final DescricaoBreve ATIVIDADE_12 = new DescricaoBreve("Marcar ferias no periodo solicitado");
    public static final DescricaoBreve ATIVIDADE_13 = new DescricaoBreve("Avisar o colaborador da rejeicao do pedido");
    public static final DescricaoBreve ATIVIDADE_21 = new DescricaoBreve("atividadeAprovacaoS2");
    public static final DescricaoBreve ATIVIDADE_22 = new DescricaoBreve("Enviar email ao colaborador");
    public static final DescricaoBreve ATIVIDADE_23 = new DescricaoBreve("Enviar email ao colaborador");
    public static final DescricaoBreve ATIVIDADE_31 = new DescricaoBreve("Alterar Residencia");
    public static final DescricaoBreve ATIVIDADE_32 = new DescricaoBreve("Avisar o colaborador da rejeicao do pedido");
    public static final DescricaoBreve ATIVIDADE_41 = new DescricaoBreve("Requerer cotacao venda por grosso");
    
    public static final IdentificadorPedido PEDIDO_1 = new IdentificadorPedido("2021/00664");
    public static final IdentificadorPedido PEDIDO_2 = new IdentificadorPedido("2021/00665");
    public static final IdentificadorPedido PEDIDO_3 = new IdentificadorPedido("2021/00666");

    public static final MecanographicNumber CLIENT_USER_1 = new MecanographicNumber("isep959");
    public static final MecanographicNumber CLIENT_USER_2 = new MecanographicNumber("user1");

    public static final String FLUXO_1 = "fluxo1";
    public static final String FLUXO_2 = "fluxo2";
    public static final String FLUXO_3 = "fluxo3";
    public static final String FLUXO_4 = "fluxo4";

    public static final String USER_TEST1 = "user1";

    @SuppressWarnings("squid:S2068")
    public static final String PASSWORD1 = "Password1";

    private TestDataConstants() {
        // ensure utility
    }
}
