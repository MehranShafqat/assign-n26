/// <reference types="Cypress" />
const TESTDATA = require('../fixtures/test_data.json')

describe('Dog By Sub Breed Name apis', () => {

    it('Get Dogs by Sub Breed Name', () => {
        cy.api({
            method: 'GET',
            url: '/breed/hound/list',
            headers: { "Content-Type": "application/json;charset=UTF-8" }
        })//Tests
            .its('body')
            .then((body) => {
                expect(body.status).eq('success');
                expect(body.message.length).gte(0);
                cy.log(JSON.stringify(body))
            })
    })
})