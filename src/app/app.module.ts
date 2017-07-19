import { NgModule, ErrorHandler, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { MyApp } from './app.component';
import { AgmCoreModule } from 'angular2-google-maps/core';

//PAGAS
import { HomePage } from '../pages/home/home';
import { ItemsPage } from '../pages/items/items';

import { ItemDetailsPageLogin } from '../pages/item-details-login/item-details-login';
import { ItemDetailsPageRegister } from '../pages/item-details-register/item-details-register';


//components
import { Spinner } from '../components/spinner/spinner';
import { SplashScreenLayout1 } from '../components/splash-screen/layout-1/splash-screen-layout-1';
import { SplashScreenLayout2 } from '../components/splash-screen/layout-2/splash-screen-layout-2';
import { SplashScreenLayout3 } from '../components/splash-screen/layout-3/splash-screen-layout-3';

import { SearchBarLayout1 } from '../components/search-bar/layout-1/search-bar-layout-1';
import { SearchBarLayout2 } from '../components/search-bar/layout-2/search-bar-layout-2';
import { SearchBarLayout3 } from '../components/search-bar/layout-3/search-bar-layout-3';

import { LoginLayout1 } from '../components/login/layout-1/login-layout-1';
import { LoginLayout2 } from '../components/login/layout-2/login-layout-2';
import { RegisterLayout1 } from '../components/register/layout-1/register-layout-1';
import { RegisterLayout2 } from '../components/register/layout-2/register-layout-2';

import { AngularFireModule } from 'angularfire2';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { AngularFireAuthModule } from 'angularfire2/auth';

export const firebaseConfig = {
    apiKey: "AIzaSyByV5lQg-OI4XXx9aNYvEsEx27dlIhWF2Y",
    authDomain: "slamgig-46d84.firebaseapp.com",
    databaseURL: "https://slamgig-46d84.firebaseio.com",
    projectId: "slamgig-46d84",
    storageBucket: "slamgig-46d84.appspot.com",
    messagingSenderId: "217217079136"
};

  // Initialize Firebase
//   var config = {
//     apiKey: "AIzaSyByV5lQg-OI4XXx9aNYvEsEx27dlIhWF2Y",
//     authDomain: "slamgig-46d84.firebaseapp.com",
//     databaseURL: "https://slamgig-46d84.firebaseio.com",
//     projectId: "slamgig-46d84",
//     storageBucket: "slamgig-46d84.appspot.com",
//     messagingSenderId: "217217079136"
//   };
//   firebase.initializeApp(config);


@NgModule({
    declarations: [
       // ElasticHeader,
        MyApp,
        HomePage,
        ItemsPage,
        ItemDetailsPageLogin, ItemDetailsPageRegister,
        Spinner,
        SplashScreenLayout1, SplashScreenLayout2, SplashScreenLayout3,
        SearchBarLayout1, SearchBarLayout2, SearchBarLayout3,
        LoginLayout1, LoginLayout2, RegisterLayout1, RegisterLayout2,
    ],
    imports: [
        BrowserModule,
        HttpModule,
        IonicModule.forRoot(MyApp),
        AgmCoreModule.forRoot({
        apiKey: 'AIzaSyByV5lQg-OI4XXx9aNYvEsEx27dlIhWF2Y'
        }),
        AngularFireModule.initializeApp(firebaseConfig),
        AngularFireDatabaseModule, AngularFireAuthModule
    ],
    bootstrap: [IonicApp],
    entryComponents: [
        MyApp,
        HomePage,
        ItemsPage,
        ItemDetailsPageLogin, ItemDetailsPageRegister,
        Spinner, SplashScreenLayout1, SplashScreenLayout2, SplashScreenLayout3,
        SearchBarLayout1, SearchBarLayout2, SearchBarLayout3,
        LoginLayout1, LoginLayout2, RegisterLayout1, RegisterLayout2,
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ],
    exports: [
       // ElasticHeader
    ],
    providers: [{ provide: ErrorHandler, useClass: IonicErrorHandler }]
})
export class AppModule { }
