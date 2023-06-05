//
//  PrincipalView.swift
//  Telas
//
//  Created by Valéria Cavalcanti on 05/06/23.
//

import SwiftUI

struct PrincipalView: View {
    @ObservedObject var telaVM: TelaViewModel
    
    var body: some View {
        VStack{
            Spacer()
            Text("PRINCIPAL")
                .font(.largeTitle)
                .fontWeight(.bold)
            Spacer()
            formulario
            sobre
            Spacer()
        }
    }
}

extension PrincipalView{
    var formulario: some View{
        Button("Formulário"){
            self.telaVM.tela = .formulario
        }
        .font(.title)
        .padding()
        .background(Color.blue)
        .foregroundColor(.white)
        .cornerRadius(20)
    }
}

extension PrincipalView{
    var sobre: some View{
        Button("Sobre"){
            self.telaVM.tela = .sobre
        }
        .font(.title)
        .padding()
        .background(Color.red)
        .foregroundColor(.white)
        .cornerRadius(20)
    }
}

struct PrincipalView_Previews: PreviewProvider {
    static var previews: some View {
        PrincipalView(telaVM: TelaViewModel())
    }
}
