
package com.projetos.projetochdedetizadora.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TipoPessoa {
    private static ObservableList<String> obsList;
    
    public static ObservableList tipoPessoa(){
        obsList = FXCollections.observableArrayList(
            "P.FISICA","P.JURÍDICA");
        return obsList;
    }    
}
