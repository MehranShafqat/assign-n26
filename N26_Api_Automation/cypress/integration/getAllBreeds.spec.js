/// <reference types="Cypress" />
const TESTDATA = require('../fixtures/test_data.json')

describe('Dog Breed apis', function () {


    it('Get all breeds', function () {
        cy.api({
            method: 'GET',
            url: '/breeds/list/all',
            headers: { "Content-Type": "application/json;charset=UTF-8" }
        })//Tests
            .its('body')
            .then((body) => {
                expect(body.status).eq('success');
                expect(body.message.australian[0]).eq('shepherd')
            })
    })
})