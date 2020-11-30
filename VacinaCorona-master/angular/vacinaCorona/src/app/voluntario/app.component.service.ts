import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {catchError, retry} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AppComponentService {
  constructor(private http: HttpClient) { }

  url = 'http://localhost:8080/';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  getGovernos(): Observable<Object[]> {
    return this.http.get<Object[]>(this.url+"vacina/governos")
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  getEmpresas(): Observable<Object[]> {
    return this.http.get<Object[]>(this.url+"vacina/empresas")
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  getPaises(): Observable<Object[]> {
    return this.http.get<Object[]>(this.url+"vacina/paises-teste")
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  salvarVacina(vacina): Observable<Object> {
    return this.http.post<Object>(this.url+"vacina", vacina, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      )
  }

  alterarVacina(vacina): Observable<Object> {
    return this.http.put<Object>(this.url+"vacina", vacina, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      )
  }

  getVacinas(): Observable<Object[]> {
    return this.http.get<Object[]>(this.url+"vacina")
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  excluirVacinas(id): Observable<Object[]> {
    return this.http.delete<Object[]>(this.url+"vacina/"+id)
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  salvarPesquisador(pesquisador): Observable<Object> {
    return this.http.post<Object>(this.url+"pesquisador", pesquisador, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      )
  }

  excluirPesquisador(id): Observable<Object[]> {
    return this.http.delete<Object[]>(this.url+"pesquisador/"+id)
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  alterarPesquisador(pesquisador): Observable<Object> {
    return this.http.put<Object>(this.url+"pesquisador", pesquisador, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      )
  }

  listarPesquisadores(): Observable<Object[]> {
    return this.http.get<Object[]>(this.url+"pesquisador")
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  salvarVoluntario(voluntario): Observable<Object> {
    return this.http.post<Object>(this.url+"voluntario", voluntario, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      )
  }

  listarVoluntarios(): Observable<Object[]> {
    return this.http.get<Object[]>(this.url+"voluntario")
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  alterarVoluntario(voluntario): Observable<Object> {
    return this.http.put<Object>(this.url+"voluntario", voluntario, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      )
  }

  excluirVoluntarios(id){
    return this.http.delete<Object[]>(this.url+"voluntario/"+id)
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      return of(result as T);
    };
  }
}
