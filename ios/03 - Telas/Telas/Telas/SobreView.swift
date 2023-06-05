//
//  SobreView.swift
//  Telas
//
//  Created by Valéria Cavalcanti on 05/06/23.
//

import SwiftUI

struct SobreView: View {
    @ObservedObject var telaVM: TelaViewModel
    
    var body: some View {
        VStack{
            Spacer()
            Text("SOBRE")
                .font(.largeTitle)
                .fontWeight(.bold)
                .foregroundColor(.white)
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
        .background(Color.red)
    }
}

struct SobreView_Previews: PreviewProvider {
    static var previews: some View {
        SobreView(telaVM: TelaViewModel())
    }
}
