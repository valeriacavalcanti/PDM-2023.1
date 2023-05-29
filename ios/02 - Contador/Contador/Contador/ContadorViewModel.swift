//
//  ContadorViewModel.swift
//  Contador
//
//  Created by Valéria Cavalcanti on 29/05/23.
//

import Foundation

class ContadorViewModel: ObservableObject{
    @Published var numero = 0
    
    func incrementar(){
        if (self.numero < 10){
            self.numero += 1
        }
    }
    
    func decrementar() {
        if (self.numero > 0){
            self.numero -= 1
        }
    }
}
