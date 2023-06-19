//
//  GastoView.swift
//  Gastos
//
//  Created by Valéria Cavalcanti on 19/06/23.
//

import SwiftUI

struct GastoView: View {
    var gasto: Gasto
    
    var body: some View {
        HStack{
            Image(systemName: "\(self.gasto.tipo).circle.fill")
                .font(.largeTitle)
            Text("\(self.gasto.descricao) - R$ \(self.gasto.valor)")
            Spacer()
        }
        .padding()
    }
}

struct GastoView_Previews: PreviewProvider {
    static var previews: some View {
        GastoView(gasto: Gasto(tipo: "d", descricao: "bolo", valor: 100.00))
    }
}
