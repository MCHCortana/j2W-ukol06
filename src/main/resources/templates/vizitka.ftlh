[#ftl]
[@c.page]
    <div class="detail">
        <div class="vizitka">
            <form method="post" action="/delete"><input type="hidden" name="id" value="${jednavizitka.id}"/>
                <div class="vymazat">
                    <button class="btn btn-primary"><i class="bi bi-trash"></i></button>
                </div>
            </form>
            <div class="jmeno">${jednavizitka.celeJmeno} </div>
            <div class="firma">${jednavizitka.firma}</div>
            <div class="udaje">
                <div class="adresa">
                    <div>${jednavizitka.ulice}</div>
                    <div><span>${jednavizitka.psc}</span> <span>${jednavizitka.obec}</span></div>
                </div>
                <div class="kontakty">
                    <div><i class="las la-at"></i><span>${jednavizitka.email?default('není uvedeno')}</span></div>
                    <div><i class="las la-phone-alt"></i> <span>${jednavizitka.telefon?default('není uvedeno')}</span>
                    </div>
                    <div><i class="las la-globe"></i> <span>${jednavizitka.web?default('není uvedeno')}</span></div>
                </div>
            </div>
        </div>

        <div class="mapa">
            <iframe style="border:none" src="https://frame.mapy.cz/?q=${jednavizitka.celaAdresa?url}" width="100%"
                    height="100%"
                    frameborder="0"></iframe>
        </div>

        [@c.back /]
    </div>
[/@c.page]
