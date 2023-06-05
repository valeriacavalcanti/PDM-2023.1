//
//  FormularioView.swift
//  Telas
//
//  Created by Valéria Cavalcanti on 05/06/23.
//

import SwiftUI

struct FormularioView: View {
    @ObservedObject var telaVM: TelaViewModel
    
    var body: some View {
        VStack{
            Spacer()
            Text("FORMULÁRIO")
                .font(.largeTitle)
                .fontWeight(.bold)
            Spacer()
            Spacer()
            Button{
                self.telaVM.tela = .principal
            }label: {
                Label("", systemImage: "arrow.left")
                    .padding()
                    .foregroundColor(.white)
                    .background(Color.black)
                    .font(.largeTitle)
                    .cornerRadius(40)
            }
            Spacer()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.blue)
    }
}

struct FormularioView_Previews: PreviewProvider {
    static var previews: some View {
        FormularioView(telaVM: TelaViewModel())
    }
}
