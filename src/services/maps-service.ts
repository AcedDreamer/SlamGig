import { IService } from './IService';
import { Toast } from 'ionic-native';

export class MapsService implements IService {

    constructor() { }

    getId = (): string => 'maps';

    getTitle = (): string => 'Maps';

    getAllThemes = (): Array<any> => {
        return [
          {"title" : "GMAPS + Location  Details", "theme"  : "layout1"},
          {"title" : "GMAPS + About Us", "theme"  : "layout2"},
          {"title" : "Full Screen View", "theme"  : "layout3"}
        ];
    };

     getEventsForTheme = (menuItem: any): any => {
        return {
            'onLike': function(item: any) {
                if (window.location.hostname === "localhost") {
                    console.log("Like");
                } else {
                    Toast.show("Like", '1000', 'bottom').subscribe(toast => { });
                }
            },
            'onFavorite': function(item: any) {
                if (window.location.hostname === "localhost") {
                    console.log("Favorite");
                    if (item) {
                        item.favorite = !item.favorite;
                    }
                } else {
                    Toast.show("Favorite", '1000', 'bottom').subscribe(toast => { });
                }
            },
            'onShare': function(item: any) {
                if (window.location.hostname === "localhost") {
                    console.log("Share");
                } else {
                    Toast.show("Share", '1000', 'bottom').subscribe(toast => { });
                }
            },
            'onSkipPrevious': function(item: any) {
                if (window.location.hostname === "localhost") {
                    console.log("Skip Previous");
                } else {
                    Toast.show("Skip Previous", '1000', 'bottom').subscribe(toast => { });
                }
            },
            'onPlay': function(item: any) {
                if (window.location.hostname === "localhost") {
                    console.log("Play");
                } else {
                    Toast.show("Play", '1000', 'bottom').subscribe(toast => { });
                }
            },
            'onSkipNext': function(item: any) {
                if (window.location.hostname === "localhost") {
                    console.log("Skip Next");
                } else {
                    Toast.show("Skip Next", '1000', 'bottom').subscribe(toast => { });
                }
            },
            'onFab': function(item: any) {
                if (window.location.hostname === "localhost") {
                    console.log("Fab");
                } else {
                    Toast.show("Fab", '1000', 'bottom').subscribe(toast => { });
                }
            },
            'onRates' : function(index: number) {
              if (window.location.hostname === "localhost") {
                console.log("Rates " + (index+1));
              } else {
                Toast.show("Rates " + (index+1), '1000', 'bottom').subscribe(toast => { });
              }
            },
            'onItemClick': function(item: any) {
                if (window.location.hostname === "localhost") {
                    console.log(item.title);
                } else {
                    Toast.show(item.title, '1000', 'bottom').subscribe(toast => { });
                }
            },
        };
    };

    prepareParams = (item: any) => {
        let result = {
            title: item.title,
            data: {},
            theme: item.theme,
            events: this.getEventsForTheme(item)
        };
        result[this.getShowItemId(item)] = true;
        return result;
    };

    getShowItemId = (item: any): string => {
        return this.getId() + item.theme.charAt(0).toUpperCase() + "" + item.theme.slice(1);
    }
}
