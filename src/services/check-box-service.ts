import { IService } from './IService';
import { Toast } from 'ionic-native';

export class CheckBoxService implements IService {

    constructor() { }

    getId = (): string => 'checkBoxes';

    getTitle = (): string => 'Check Boxes';

    getAllThemes = (): Array<any> => {
        return [
          {"title" : "Simple", "theme"  : "layout1"},
          {"title" : "With Avatar", "theme"  : "layout2"},
          {"title" : "Simple", "theme"  : "layout3"}
        ];
    };

    getDataForTheme = (menuItem: any): any => {
        return this[
            'getDataFor' +
            menuItem.theme.charAt(0).toUpperCase() +
            menuItem.theme.slice(1)
        ]();
    };

    getEventsForTheme = (menuItem: any): any => {
        return {
            onButton: function(item: any) {
                if (window.location.hostname === "localhost") {
                    console.log(JSON.stringify(item));
                } else {
                    Toast.show(item.title, '1000', 'bottom').subscribe(toast => { });
                }
            }
        };
    };

    prepareParams = (item: any) => {
        let result = {
            title: item.title,
            data: [],
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
