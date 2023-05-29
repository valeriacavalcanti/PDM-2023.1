//
//  ContentView.swift
//  Contador
//
//  Created by Valéria Cavalcanti on 26/05/23.
//

import SwiftUI

struct ContentView: View {
//    @State var numero = 0
    @ObservedObject var contadorVM: ContadorViewModel
    
    var body: some View {
        VStack{
            Text("Valor: \(self.contadorVM.numero.description)")
                .font(.largeTitle)
            HStack{
                addButton
                delButton
            }
        }
    }
}

extension ContentView{
    var addButton: some View{
        Button("+"){
            self.contadorVM.incrementar()
        }
        .frame(width: 60, height: 60)
        .font(.largeTitle)
        .background(Color.green)
        .foregroundColor(.white)
    }
}

extension ContentView{
    var delButton: some View{
        Button("-"){
            self.contadorVM.decrementar()
        }
        .frame(width: 60, height: 60)
        .font(.largeTitle)
        .background(Color.red)
        .foregroundColor(.white)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(contadorVM: ContadorViewModel())
    }
}
