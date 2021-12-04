import { Link } from '../modelo/Link';
import { Component, OnInit } from '@angular/core';
import { LinkService } from '../servicos/link.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.scss']
})
export class PrincipalComponent implements OnInit {
  form: FormGroup = this.fb.group({
    urlOriginal: ['', [Validators.required]]
  })

  constructor(
    private linkServico: LinkService,
    private fb: FormBuilder) { }

  public link: Link = new Link();
  public mostrarResultado: boolean = false
  public linkResultado: any
  public carregando: boolean = false

  ngOnInit(): void {
  }

  gerarLink() {
    this.form.markAllAsTouched()
    if (this.form.invalid) return;
    this.link = new Link(this.form.controls['urlOriginal'].value)
    this.carregando = true
    this.linkServico.gerarLink(this.link).subscribe(response => {
      this.linkServico.mostrarMensagem("Link gerado com sucesso!", 3000);
      this.linkResultado = environment.baseUrl+"/"+response.codigo
      this.mostrarResultado = true;
      this.carregando = false
    })
  }

  copiar() {
    this.copiarParaAreaTrasnferencia(this.linkResultado)
  }


  zerar() {
    this.form.reset()
    this.form.untouched
    this.mostrarResultado = false
  }

  copiarParaAreaTrasnferencia(text:string){
    if (document.queryCommandSupported && document.queryCommandSupported("copy")) {
      var textarea = document.createElement("textarea");
      textarea.textContent = text;
      textarea.style.position = "fixed";
      document.body.appendChild(textarea);
      textarea.select();
      try {
         document.execCommand("copy");
         this.linkServico.mostrarMensagem("Link Copiado",3000);
      }
      catch (ex) {
        console.warn("Copy to clipboard failed.", ex);
        
      }
      finally {
        document.body.removeChild(textarea);
      }
    }
  }
}
