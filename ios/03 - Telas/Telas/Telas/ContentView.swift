//
//  ContentView.swift
//  Telas
//
//  Created by Valéria Cavalcanti on 05/06/23.
//

import SwiftUI

struct ContentView: View {
    @ObservedObject var telaVM: TelaViewModel
    
    var body: some View {
        if self.telaVM.tela == .principal{
            PrincipalView(telaVM: self.telaVM)
        }else if self.telaVM.tela == .formulario{
            FormularioView(telaVM: self.telaVM)
        }else{
            SobreView(telaVM: self.telaVM)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(telaVM: TelaViewModel())
    }
}
