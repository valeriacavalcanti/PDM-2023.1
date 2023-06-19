//
//  Gasto.swift
//  Gastos
//
//  Created by Valéria Cavalcanti on 19/06/23.
//

import Foundation

class Gasto: NSObject, Identifiable{
    var tipo: String
    var descricao: String
    var valor: Double
    
    override var description: String{
        return "\(tipo) - \(descricao) - R$ \(valor)"
    }
    
    init(tipo: String, descricao: String, valor: Double) {
        self.tipo = tipo
        self.descricao = descricao
        self.valor = valor
    }
}
