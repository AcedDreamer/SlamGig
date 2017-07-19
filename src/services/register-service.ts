import { IService } from './IService';
import { Toast } from 'ionic-native';

export class RegisterService implements IService {

    constructor() { }

    getId = (): string => 'register';

    getTitle = (): string => 'Register pages';

    getAllThemes = (): Array<any> => {
        return [
          {"title" : "Register + logo 1", "theme"  : "layout1"},
          {"title" : "Register + logo 2", "theme"  : "layout2"}
        ];
    };

    getEventsForTheme = (menuItem: any): any => {
        return {
            onRegister: function(params) {
                if (window.location.hostname === "localhost") {
                    console.log('onRegister:' + JSON.stringify(params));
                } else {
                    Toast.show('onRegister:' + JSON.stringify(params), '1000', 'bottom').subscribe(toast => { });
                }
            },
            onSkip: function(params) {
                if (window.location.hostname === "localhost") {
                    console.log('onSkip:' + JSON.stringify(params));
                } else {
                    Toast.show('onSkip:' + JSON.stringify(params), '1000', 'bottom').subscribe(toast => { });
                }
            }
        };
    };



    prepareParams = (item: any) => {
        let result = {
            title: item.title,
            theme: item.theme,
            data: {},
            events: this.getEventsForTheme(item)
        };
        result[this.getShowItemId(item)] = true;
        return result;
    };

    getShowItemId = (item: any): string => {
        return this.getId() + item.theme.charAt(0).toUpperCase() + "" + item.theme.slice(1);
    }
}
