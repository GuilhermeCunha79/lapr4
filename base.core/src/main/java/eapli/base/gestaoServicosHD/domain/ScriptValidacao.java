/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.ValueObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ScriptValidacao implements ValueObject {
    
    @Column(length=500)
    private String conteudo;

    public ScriptValidacao(File ficheiro) throws IOException {
        fileToString(ficheiro);
    }

    protected ScriptValidacao() {
    }

    private void fileToString(File f) throws IOException {

        Path path = Paths.get(f.getAbsolutePath());

        StringBuilder sb = new StringBuilder();

        Stream<String> stream = Files.lines(path);
        stream.forEach(s -> sb.append(s).append("\n"));

        String conteudoFicheiro = sb.toString();
        this.conteudo = conteudoFicheiro;

    }

    public String Conteudo() {
        return conteudo;
    }

}
