[#ftl]
[@c.page]
    <div class="detail">
        [@form.form  method="post" class="vizitka" bind="vizitka"]
            [@form.input name="celeJmeno" label="Jméno" maxlength="100" /]
            [@form.input name="firma" label="Firma" maxlength="100" required="required" /]
            [@form.input name="ulice" label="Ulice a čísla" maxlength="100" required="required" /]
            [@form.input name="obec" label="Obec" maxlength="100" required="required" /]
            [@form.input name="psc" label="PSČ ve formátu xxxxx" minlength="5" maxlength="5" pattern="[0-9]{5}" required="required" /]
            [@form.input name="email" label="E-mail" maxlength="100" type="email" /]
            [@form.input name="telefon" label="Telefon" maxlength="100"  type="tel" /]
            [@form.input name="web" type="url" label="Web" maxlength="100" /]
            <div class="form-controls">
                <button type="submit">Odeslat</button>
            </div>
        [/@form.form]
        [#if vizitka.id??]
            <div class="edit-delete">
                [@form.form method="post" action="/delete"  class="edit-delete--form" bind="vizitka"]
                    [@form.input name="id" type="hidden" value="${vizitka.id}" label="Smazat záznam" /]
                    <div class="form-controls">
                        <button type="submit" class="btn btn-primary"><i class="bi bi-trash"></i></button>
                    </div>
                [/@form.form]
            </div>
        [/#if]

    </div>
    [@c.back /]
[/@c.page]