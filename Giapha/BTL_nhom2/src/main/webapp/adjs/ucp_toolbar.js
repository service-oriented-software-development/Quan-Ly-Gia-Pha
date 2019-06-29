/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
    CKEDITOR.config.entities = false;
    config.toolbar =
    [
        { name: 'basicstyles', items: ['Bold', 'Italic', 'Underline', 'Strike', 'TextColor', 'BGColor', '-', 'RemoveFormat', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'] },
        { name: 'styles', items: ['Styles', 'Format', 'Font', 'FontSize'] },
        { name: 'colors', items: ['TextColor', 'BGColor'] },
        { name: 'links', items: ['Link', 'Unlink'] },
        { name: 'insert', items: ['Table','Smiley', 'SpecialChar'] }
    ];

};
