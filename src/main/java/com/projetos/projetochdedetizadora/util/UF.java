
package com.projetos.projetochdedetizadora.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UF {
    private static ObservableList<String> obsList;
    
    public static ObservableList gerarUF(){
        obsList = FXCollections.observableArrayList(
            "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA",
            "MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN",
            "RS","RO","RR","SC","SP","SE","TO");
        return obsList;
    }
}
