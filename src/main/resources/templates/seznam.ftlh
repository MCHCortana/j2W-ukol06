[#ftl]
[@c.page]
    [#list seznamVizitek]
    <div class="seznam">
        [#items as vizitka]
            <a href="/vizitka/${vizitka?index}">
                <div class="vizitka">
                    <form method="post" action="/delete"><input type="hidden" name="id" value="${vizitka?index}"/>
                        <div class="vymazat">
                            <button class="btn btn-primary"><i class="bi bi-trash"></i></button>
                        </div>
                    </form>
                    <div class="jmeno">${vizitka.celeJmeno}</div>
                    <div class="firma">${vizitka.firma}</div>
                    <div class="udaje">
                        <div class="adresa">
                            <div>${vizitka.ulice}</div>
                            <div>${vizitka.obec} ${vizitka.psc}</div>
                        </div>
                        <div class="kontakty">
                            <div><i class="las la-at"></i>
                                <span>
                                    [#if vizitka.email??]${vizitka.email}[#else]není uvedeno
                                    [/#if]
                                </span>
                            </div>
                            <div><i class="las la-phone-alt"></i>
                                <span>
                                    [#if vizitka.telefon??]${vizitka.telefon}[#else]není uvedeno[/#if]
                                </span>
                            </div>
                            <div><i class="las la-globe"></i>
                                <span>[#if vizitka.web??]${vizitka.web}[#else]není uvedeno[/#if]
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        [/#items]

        <a href="/nova">
            <div class="vizitka vizitka--nova">
                <svg width="100" height="100">
                    <rect width="20" height="100" x="40" y="0" fill="white"/>
                    <rect width="100" height="20" x="0" y="40" fill="white"/>
                </svg>
            </div>
        </a>
    </div>
    [/#list]
[/@c.page]
