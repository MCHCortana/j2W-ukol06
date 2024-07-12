package cz.czechitas.java2webapps.ukol6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public class Vizitka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Zadejte celé jméno")
//    @Pattern(regexp = "(?i)\\w+\\s+\\w+", message = "Nezapomněli jste zadat příjmení?")
    @Length(max = 100)
    private String celeJmeno;
    @NotBlank(message = "Zadejte společnost, kterou kontakt pracuje zastupuje.")
    @Length(max = 100)
    private String firma;

    @NotBlank(message = "Zadejte ulici, na které se společnost nachází.")
    @Length(max = 100)
    private String ulice;

    @NotBlank(message = "Zadejte obec, ve které se společnost nachází.")
    @Length(max = 100)
    private String obec;

    @NotBlank(message = "Zadejte PSČ, uvedené obce.")
    @Pattern(regexp = "\\d{5}", message = "Zadejte PSČ ve formátu XXXXX")
    private String psc;
    @Email(message = "Zadejte email ve správném formátu.")
    @Length(max = 100)
    private String email;
    @Pattern(regexp = "\\+?\\d+")
    @Length(min = 9, max = 20)
    private String telefon;

    @Length(max = 100)
//    @URL(message = "Zadejte webovou stránku")
    private String web;

    public Vizitka() {
    }

    public Vizitka(Long id, String celeJmeno, String firma, String ulice, String obec, String psc, String email, String telefon, String web) {
        this.id = id;
        this.celeJmeno = celeJmeno;
        this.firma = firma;
        this.ulice = ulice;
        this.obec = obec;
        this.psc = psc;
        this.email = email;
        this.telefon = telefon;
        this.web = web;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public final String getCelaAdresa() {
        return this.ulice + " " + this.obec + " " + this.psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}

