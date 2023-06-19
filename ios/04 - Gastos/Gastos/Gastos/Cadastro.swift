//
//  Cadastro.swift
//  Gastos
//
//  Created by Valéria Cavalcanti on 19/06/23.
//

import Foundation

class Cadastro: ObservableObject{
    @Published var lista: [Gasto]
    
    init() {
        self.lista = []
    }
}
