import { environment } from './../../environments/environment';
import { Link } from '../modelo/Link';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class LinkService {


  private baseUrl = environment.baseUrl
  constructor(
    private snackBar: MatSnackBar,
    private http: HttpClient) { }

  gerarLink(link: Link): Observable<Link> {
    return this.http.post<Link>(this.baseUrl, link);
  }

  mostrarMensagem(msg: string) {
    this.snackBar.open(msg, '', {
      duration: 4000,
      horizontalPosition: "right",
      verticalPosition: "bottom"
    })
  }
}
