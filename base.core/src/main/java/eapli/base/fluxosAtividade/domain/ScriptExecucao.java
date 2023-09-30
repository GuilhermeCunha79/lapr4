package eapli.base.fluxosAtividade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.persistence.Column;

@Embeddable
public class ScriptExecucao implements ValueObject {
    
    @Column(length=1000)
    private String content;

    public ScriptExecucao(File file) throws IOException {
        fileToString(file);
    }

    protected ScriptExecucao() {
    }


    private void fileToString(File f) throws IOException {

        Path path = Paths.get(f.getAbsolutePath());

        StringBuilder sb = new StringBuilder();

        Stream<String> stream = Files.lines(path);
        stream.forEach(s -> sb.append(s).append("\n"));

        String conteudoFicheiro = sb.toString();
        this.content = conteudoFicheiro;

    }

    public String Conteudo() {
        return content;
    }
}
