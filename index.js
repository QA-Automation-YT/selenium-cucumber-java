const report = require('multiple-cucumber-html-reporter');

report.generate({
    jsonDir: './test/report/',
    reportPath: './test/report/',
    openReportInBrowser: true,
    metadata:{
        browser: {
            name: 'chrome',
            version: '60'
        },
        device: 'Local test machine',
        platform: {
            name: 'Windows',
            version: '10 Pro'
        }
    },
    customData: {
        title: 'Run info',
        data: [
            {label: 'Project', value: 'Framework QA Automation'},
            {label: 'Release', value: '1.0'}
        ]
    }
});