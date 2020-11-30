import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VacinaComponent } from './vacina/vacina.component';
import { PesquisadorComponent } from './pesquisador/pesquisador.component';
import { VoluntarioComponent } from './voluntario/voluntario.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppComponentService} from "./voluntario/app.component.service";

@NgModule({
  declarations: [
    AppComponent,
    VacinaComponent,
    PesquisadorComponent,
    VoluntarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [AppComponentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
