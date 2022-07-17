/// <reference types="Cypress" />
const TESTDATA = require('../fixtures/test_data.json')

describe('Dog By Breed Name apis', function () {

    it('Get Dogs by Breed Name', function () {
        cy.api({
            method: 'GET',
            url: '/breed/hound/images',
            headers: { "Content-Type": "application/json;charset=UTF-8" }
        })//Tests
            .its('body')
            .then((body) => {
                expect(body.status).eq('success');
                expect(body.message.length).gte(0);
                expect(body.message[0]).contains("https://images.dog.ceo/breeds/hound-afghan")
                cy.log(JSON.stringify(body))
            })
    })
})