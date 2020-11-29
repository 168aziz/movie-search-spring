$(document).ready(function () {
    function lazyload() {
        $('.lazy').Lazy({
            // your configuration goes here
            scrollDirection: 'vertical',
            effect: 'fadeIn',
            visibleOnly: true,
            onError: function (element) {
                console.log('error loading ' + element.data('src'));
            }
        });
    }


    lazyload();

    $('.filter-item').click(function (e) {
        e.preventDefault();

        $('.filter-item').removeClass('filter-active');
        $('.tabs_block').removeClass('tab-block--active');

        $(this).addClass('filter-active');

        $($(this).attr('href')).addClass('tab-block--active');
        lazyload();

    });

    $('.filter-item:first').click();
    lazyload();


    var main = document.getElementsByTagName('main')[0];
    var moviesRow = $("#movie-row")[0];
    var tvShowsRow = $("#tvshow-row")[0];
    var peopleRow = $("#people-row")[0];

    var query = $(main).attr('data-query');

    var movieget = $("#movieget")[0];
    var tvshowget = $("#tvshowget")[0];
    var peopleget = $("#peopleget")[0];


    $('#mbtn').click(function () {
        uploadMore('/movie', moviesRow, movieget, 'movie');
    });
    $('#tbtn').click(function () {
        uploadMore('/tv', tvShowsRow, tvshowget, 'tv');
    });
    $('#pbtn').click(function () {
        uploadMore('/people', peopleRow, peopleget, 'people');
    });

    function uploadMore(url, row, beforeBlock, type) {
        let page = parseInt($(row).attr('data-current-page')) + 1;
        let totalPage = parseInt($(row).attr('data-total-page'));

        $.ajax({
            type: "GET",
            url: '/upload' + url,
            data: {search: query, page: page, type: type},
            success: function (text) {

                $(beforeBlock).before(text);
                lazyload();
                if (page >= totalPage) {
                    beforeBlock.remove();
                } else {
                    $(row).attr('data-current-page', page);
                }
            }
        });
    }
});


