//
//  TelasApp.swift
//  Telas
//
//  Created by Valéria Cavalcanti on 05/06/23.
//

import SwiftUI

@main
struct TelasApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView(telaVM: TelaViewModel())
        }
    }
}
