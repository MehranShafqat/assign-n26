/// <reference types="Cypress" />
const TESTDATA = require('../fixtures/test_data.json')

describe('Dog By Random Breed Name apis', () => {

    it('Search Random Breeds', () => {
        cy.api({
            method: 'GET',
            url: `/breed/african/images/random`,
            headers: { "Content-Type": "application/json;charset=UTF-8" }
        })//Tests
            .its('body')
            .then((body) => {
                expect(body.status).eq('success');
                cy.log(JSON.stringify(body))
            })
    })
})