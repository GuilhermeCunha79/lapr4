/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML {

    public static List<String> obterPrecoECategoriaProduto(String codigoProduto) {
       List<String> precoCategoria=new ArrayList<>();
        try {    
            File file = new File("XMLFile.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("product");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (codigoProduto.equals(eElement.getElementsByTagName("codigo").item(0).getTextContent())) {
                        precoCategoria.add(eElement.getElementsByTagName("preco").item(0).getTextContent());
                        precoCategoria.add(eElement.getElementsByTagName("categoria").item(0).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return precoCategoria;
    }
    
    public static void atualizaParametro(String categoria, String valor,String parametro){
         try {    
            File file = new File("XMLFile.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("product");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (categoria.equals(eElement.getElementsByTagName("categoria").item(0).getTextContent())) {
                        int somar=Integer.parseInt(valor);
                        int base =Integer.parseInt(eElement.getElementsByTagName(parametro).item(0).getTextContent());
                        eElement.getElementsByTagName(parametro).item(0).setTextContent(String.valueOf(somar+base));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


