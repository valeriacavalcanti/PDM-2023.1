//
//  FormView.swift
//  Gastos
//
//  Created by Valéria Cavalcanti on 19/06/23.
//

import SwiftUI

struct FormView: View {
    @State var tipo: String = "d"
    @State var descricao: String = ""
    @State var valor:String = ""
    @EnvironmentObject var cadastro: Cadastro
    
    var body: some View {
        VStack{
            Picker("Tipo", selection: self.$tipo) {
                Text("Alimentação").tag("a")
                Text("Diversão").tag("d")
                Text("Hospedagem").tag("h")
                Text("Transporte").tag("t")
            }.pickerStyle(.inline)
            Spacer()
            TextField("Descrição", text: self.$descricao)
            Spacer()
            TextField("Valor", text: self.$valor)
            Spacer()
        }
        .padding()
        .navigationTitle("Novo Gasto")
        .toolbar {
            ToolbarItem {
                Button("Salvar"){
                    var gasto = Gasto(tipo: self.tipo, descricao: self.descricao, valor: Double(self.valor) ?? 0.0)
                    self.cadastro.lista.append(gasto)
                }
            }
        }
    }
}

struct FormView_Previews: PreviewProvider {
    static var previews: some View {
        FormView()
    }
}
