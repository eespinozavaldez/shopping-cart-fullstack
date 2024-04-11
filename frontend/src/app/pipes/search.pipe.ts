import { Injectable, Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search'
})

export class SearchPipe implements PipeTransform {
  
  transform(data: Array<any>, searchTxt: string ): Array<any> {
    return data.filter(getData);
        function getData(value, index){
            if(value.name.toUpperCase().indexOf(searchTxt.toUpperCase()) > -1 ) {
                return data[index];
              }
               
        };
  };
}
