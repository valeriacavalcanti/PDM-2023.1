//
//  ContentView.swift
//  Gastos
//
//  Created by Valéria Cavalcanti on 19/06/23.
//

import SwiftUI

struct ContentView: View {
    @StateObject var cadastro: Cadastro
    
    var body: some View {
        NavigationView {
            principal
        }
        .environmentObject(self.cadastro)
    }
}

extension ContentView{
    var principal: some View{
        VStack {
            List{
                ForEach(self.cadastro.lista){ gasto in
                    GastoView(gasto: gasto)
                }
            }
        }
        .padding()
        .navigationTitle("Gastos")
        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItem {
                NavigationLink("Novo", destination: FormView())
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(cadastro: Cadastro())
    }
}
