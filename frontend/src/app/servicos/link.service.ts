import { environment } from './../../environments/environment';
import { Link } from '../modelo/Link';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { catchError, empty, Observable } from 'rxjs';

@Injectable()
export class LinkService {


  private baseUrl = environment.baseUrl
  constructor(
    private snackBar: MatSnackBar,
    private http: HttpClient) { }

  gerarLink(link: Link): Observable<Link> {
    return this.http.post<Link>(this.baseUrl, link).
      pipe(
        catchError(error => {
        this.mostrarMensagem("Erro ao gerar link, tente novamente mais tarde!", 6000);
        return empty()
      }));
  }

  mostrarMensagem(msg: string, tempo: number ) {
    this.snackBar.open(msg, '', {
      duration: tempo,
      horizontalPosition: "right",
      verticalPosition: "bottom",
    })
  }
}
