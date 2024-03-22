import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UtenteCatalogoComponent } from './utente-catalogo/utente-catalogo.component';
import { LibroDettaglioComponent } from './libro-dettaglio/libro-dettaglio.component';
import { BackendInterceptor } from './backend.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UtenteCatalogoComponent,
    LibroDettaglioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    provideClientHydration(),
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BackendInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
