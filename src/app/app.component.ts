import { Component, ViewChild } from '@angular/core';
import { Platform, MenuController, Nav } from 'ionic-angular';
import { StatusBar, Splashscreen } from 'ionic-native';
import { MenuService } from '../services/menu-service';
import { HomePage } from '../pages/home/home';
import { ItemsPage } from '../pages/items/items';
import { AngularFireDatabase, FirebaseListObservable } from 'angularfire2/database';

@Component({
    templateUrl: 'app.html',
    providers: [MenuService]
})

export class MyApp {
    @ViewChild(Nav) nav: Nav;

    rootPage = HomePage;
    pages: any;
    leftMenuTitle: string;
    params: any;
    data: FirebaseListObservable<any>;

    constructor(public af: AngularFireDatabase, public platform: Platform,
        public menu: MenuController,
        private menuService: MenuService) {
        this.initializeApp();

        this.pages = menuService.getAllThemes();
        this.leftMenuTitle = menuService.getTitle();
        this.loadDataFromFirebase();
    }

    initializeApp() {
        this.platform.ready().then(() => {
            // Okay, so the platform is ready and our plugins are available.
            // Here you can do any higher level native things you might need.
            StatusBar.styleDefault();
            Splashscreen.hide();
            localStorage.setItem("mailChimpLocal", "true");
        });
    }

    openPage(page) {
        // close the menu when clicking a link from the menu
        this.menu.close();
        // navigate to the new page if it is not the current page
        this.nav.setRoot(ItemsPage, {
            componentName: page.theme
        });
    }

    loadDataFromFirebase() {
        this.data = this.af.list('menu');
        let that = this;
        that.params = {};
        this.data.forEach(function(element) {
            if (element != null) {
                element.forEach(function(element) {
                    if (element["$key"] != "items") {
                        that.params[element["$key"]] = element["$value"];
                    } else {
                        that.params[element["$key"]] = element;
                    }
                });
            }
        });
    }
}
