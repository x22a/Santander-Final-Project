import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { config } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RequestService {
  tokenType: string;
  accessToken: string;
  username: string;
  userRole: string;
  baseURL: string = 'http://localhost:8094/';

  constructor(private httpClient: HttpClient) {}

  public setUser(user) {
    this.tokenType = user.tokenType;
    this.accessToken = user.accessToken;
    this.username = user.username;
    this.userRole = user.userRole;
  }

  public getToken() {
    return `${this.tokenType} ${this.accessToken}`;
  }

  public isAdmin() {
    return this.userRole === 'ROLE_ADMIN';
  }

  public signRequest(data) {
    return new Promise((resolve, reject) => {
      this.httpClient.post(`${this.baseURL}auth/sign-in`, data, { observe: 'response' }).subscribe(
        (response) => {
          resolve(response);
        },
        (error) => {
          reject(error.error.message);
        }
      );
    });
  }

  public authRequest(data) {
    return new Promise((resolve, reject) => {
      this.httpClient.post(`${this.baseURL}auth/login`, data, { observe: 'response' }).subscribe(
        (response) => {
          this.setUser(response.body);
          resolve(response);
        },
        (error) => {
          reject(error.error.message);
        }
      );
    });
  }

  public logout() {
    this.tokenType = '';
    this.accessToken = '';
  }

  public getRequest(url): any {
    const headers = new HttpHeaders().set('Authorization', this.getToken());
    console.log(headers);
    return this.httpClient.get<any>(`${this.baseURL}${url}`, { headers });
  }

  public postRequest(url, data): any {
    const headers = new HttpHeaders().set('Authorization', this.getToken());
    return this.httpClient.post(`${this.baseURL}${url}`, data, { headers });
  }

  public putRequest(url, data): any {
    const headers = new HttpHeaders().set('Authorization', this.getToken());
    console.log(headers);
    return this.httpClient.put(`${this.baseURL}${url}`, data, { headers });
  }

  public deleteRequest(url) {
    const headers = new HttpHeaders().set('Authorization', this.getToken());
    this.httpClient.delete(`${this.baseURL}${url}`, { headers }).subscribe(
      (data) => {
        console.log(data);
        return data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
